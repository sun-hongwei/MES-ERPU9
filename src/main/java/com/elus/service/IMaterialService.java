package com.elus.service;

public interface IMaterialService {

    /**
     * 将ERP中间表中物料信息同步到MES
     *
     * @return
     */
    Boolean MESERPMaterial();
}
