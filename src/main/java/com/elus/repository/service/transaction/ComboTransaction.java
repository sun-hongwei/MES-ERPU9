package com.elus.repository.service.transaction;

import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.stream.Stream;

@Component
public class ComboTransaction {

    @Autowired
    private MESTxBroker MESTxBroker;

    @Autowired
    private ERPTxBroker ERPTxBroker;

    public <V> V inCombinedTx(Callable<V> callable, String[] transactions) {
        if (callable == null) {
            return null;
        }
        Callable<V> combined = Stream.of(transactions)
                .filter(ele -> !StringUtils.isEmpty(ele))
                .distinct()
                .reduce(callable, (r, tx) -> {
                    switch (tx) {
                        case DbTxConstants.MES:
                            return () -> MESTxBroker.inTransaction(r);
                        case DbTxConstants.ERP:
                            return () -> ERPTxBroker.inTransaction(r);
                        default:
                            return null;
                    }
                }, (r1, r2) -> r2);
        try {
            return combined.call();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
