package com.elus;

import com.elus.service.IMaterialService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MesErpApplicationTests {

    @Autowired
    private IMaterialService iMaterialService;

    /**
     * 将ERP中间表中物料信息同步到MES
     */
    @Test
    void MESERPMaterial(){
        System.out.println(iMaterialService.MESERPMaterial());
    }

}
