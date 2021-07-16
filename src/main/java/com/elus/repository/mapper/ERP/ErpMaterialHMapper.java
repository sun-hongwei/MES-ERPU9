package com.elus.repository.mapper.ERP;

import com.elus.repository.model.ERP.ErpMaterialH;
import com.elus.repository.model.ERP.ErpMaterialHExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ErpMaterialHMapper {
    long countByExample(ErpMaterialHExample example);

    int deleteByExample(ErpMaterialHExample example);

    int insert(ErpMaterialH record);

    int insertSelective(ErpMaterialH record);

    List<ErpMaterialH> selectByExampleWithRowbounds(ErpMaterialHExample example, RowBounds rowBounds);

    List<ErpMaterialH> selectByExample(ErpMaterialHExample example);

    int updateByExampleSelective(@Param("record") ErpMaterialH record, @Param("example") ErpMaterialHExample example);

    int updateByExample(@Param("record") ErpMaterialH record, @Param("example") ErpMaterialHExample example);
}