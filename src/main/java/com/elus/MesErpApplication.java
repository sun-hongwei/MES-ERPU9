package com.elus;

import com.elus.repository.conf.MESDataSourceConfig;
import com.elus.repository.conf.ERPDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {MESDataSourceConfig.class, ERPDataSourceConfig.class})
public class MesErpApplication {
    public static void main(String[] args) {
        SpringApplication.run(MesErpApplication.class, args);
    }
}
