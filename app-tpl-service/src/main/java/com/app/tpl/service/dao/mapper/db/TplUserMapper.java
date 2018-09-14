package com.app.tpl.service.dao.mapper.db;

import com.app.tpl.service.dao.model.db.TplUser;
import com.app.tpl.service.dao.model.db.TplUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TplUserMapper {
    int countByExample(TplUserExample example);

    int deleteByExample(TplUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(TplUser record);

    int insertSelective(TplUser record);

    List<TplUser> selectByExample(TplUserExample example);

    TplUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") TplUser record, @Param("example") TplUserExample example);

    int updateByExample(@Param("record") TplUser record, @Param("example") TplUserExample example);

    int updateByPrimaryKeySelective(TplUser record);

    int updateByPrimaryKey(TplUser record);
}