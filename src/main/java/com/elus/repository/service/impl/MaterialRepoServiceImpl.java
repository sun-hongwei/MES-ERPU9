package com.elus.repository.service.impl;

import com.elus.repository.aop.MultiTransactional;
import com.elus.repository.mapper.MES.MesMaterialMapper;
import com.elus.repository.mapper.ERP.ErpMaterialHMapper;
import com.elus.repository.mapper.ERP.ErpMaterialMapper;
import com.elus.repository.model.MES.MesMaterial;
import com.elus.repository.model.ERP.ErpMaterial;
import com.elus.repository.model.ERP.ErpMaterialExample;
import com.elus.repository.model.ERP.ErpMaterialH;
import com.elus.repository.service.IMaterialRepoService;
import com.elus.repository.service.transaction.DbTxConstants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MaterialRepoServiceImpl implements IMaterialRepoService {

    private ErpMaterialMapper erpMaterialMapper;
    private MesMaterialMapper mesMaterialMapper;
    private ErpMaterialHMapper erpMaterialHMapper;

    @Override
    @MultiTransactional(value = {DbTxConstants.MES, DbTxConstants.ERP})
    public Boolean MESERPMaterial() {
        //1、数据从ERP中间库同步到MES库中
        ErpMaterialExample erpMaterialExample = new ErpMaterialExample();
        List<ErpMaterial> erpMaterials = erpMaterialMapper.selectByExample(erpMaterialExample);
        for (ErpMaterial erpMaterial : erpMaterials) {
            //2、数据从ERP中间库同步到MES库中
            MesMaterial mesMaterial = new MesMaterial();
            mesMaterial.setMaterialId(erpMaterial.getMaterialId());
            mesMaterial.setMaterialCode(erpMaterial.getMaterialCode());
            mesMaterial.setMaterialName(erpMaterial.getMaterialName());
            mesMaterial.setMaterialSpecification(erpMaterial.getMaterialSpecification());
            mesMaterialMapper.insert(mesMaterial);
            //3、数据从ERP中间库移动到历史表中
            ErpMaterialH erpMaterialH = new ErpMaterialH();
            erpMaterialH.setMaterialId(erpMaterial.getMaterialId());
            erpMaterialH.setMaterialCode(erpMaterial.getMaterialCode());
            erpMaterialH.setMaterialName(erpMaterial.getMaterialName());
            erpMaterialH.setMaterialSpecification(erpMaterial.getMaterialSpecification());
            erpMaterialHMapper.insert(erpMaterialH);
            //4、删除中间库数据
            erpMaterialMapper.deleteByPrimaryKey(erpMaterial.getMaterialId());
        }
        return true;
    }
}

