package com.elus.repository.service;

public interface IMaterialRepoService {
    /**
     * 将ERP中间表中物料信息同步到MES
     *
     * @return
     */
    Boolean MESERPMaterial();
}
