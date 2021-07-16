package com.elus.repository.mapper.MES;

import com.elus.repository.model.MES.MesMaterial;
import com.elus.repository.model.MES.MesMaterialExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface MesMaterialMapper {
    long countByExample(MesMaterialExample example);

    int deleteByExample(MesMaterialExample example);

    int deleteByPrimaryKey(String materialId);

    int insert(MesMaterial record);

    int insertSelective(MesMaterial record);

    List<MesMaterial> selectByExampleWithRowbounds(MesMaterialExample example, RowBounds rowBounds);

    List<MesMaterial> selectByExample(MesMaterialExample example);

    MesMaterial selectByPrimaryKey(String materialId);

    int updateByExampleSelective(@Param("record") MesMaterial record, @Param("example") MesMaterialExample example);

    int updateByExample(@Param("record") MesMaterial record, @Param("example") MesMaterialExample example);

    int updateByPrimaryKeySelective(MesMaterial record);

    int updateByPrimaryKey(MesMaterial record);
}