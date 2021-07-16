package com.elus.repository.mapper.MES;

import com.elus.repository.model.MES.MesBom;
import com.elus.repository.model.MES.MesBomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface MesBomMapper {
    long countByExample(MesBomExample example);

    int deleteByExample(MesBomExample example);

    int deleteByPrimaryKey(String materialId);

    int insert(MesBom record);

    int insertSelective(MesBom record);

    List<MesBom> selectByExampleWithRowbounds(MesBomExample example, RowBounds rowBounds);

    List<MesBom> selectByExample(MesBomExample example);

    MesBom selectByPrimaryKey(String materialId);

    int updateByExampleSelective(@Param("record") MesBom record, @Param("example") MesBomExample example);

    int updateByExample(@Param("record") MesBom record, @Param("example") MesBomExample example);

    int updateByPrimaryKeySelective(MesBom record);

    int updateByPrimaryKey(MesBom record);
}