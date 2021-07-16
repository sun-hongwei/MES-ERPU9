package com.elus.repository.mapper.ERP;

import com.elus.repository.model.ERP.ErpMaterial;
import com.elus.repository.model.ERP.ErpMaterialExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ErpMaterialMapper {
    long countByExample(ErpMaterialExample example);

    int deleteByExample(ErpMaterialExample example);

    int deleteByPrimaryKey(String materialId);

    int insert(ErpMaterial record);

    int insertSelective(ErpMaterial record);

    List<ErpMaterial> selectByExampleWithRowbounds(ErpMaterialExample example, RowBounds rowBounds);

    List<ErpMaterial> selectByExample(ErpMaterialExample example);

    ErpMaterial selectByPrimaryKey(String materialId);

    int updateByExampleSelective(@Param("record") ErpMaterial record, @Param("example") ErpMaterialExample example);

    int updateByExample(@Param("record") ErpMaterial record, @Param("example") ErpMaterialExample example);

    int updateByPrimaryKeySelective(ErpMaterial record);

    int updateByPrimaryKey(ErpMaterial record);
}