package com.app.tpl.service.dao.mapper.db;

import com.app.tpl.service.dao.model.db.TplUserRole;
import com.app.tpl.service.dao.model.db.TplUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TplUserRoleMapper {
    int countByExample(TplUserRoleExample example);

    int deleteByExample(TplUserRoleExample example);

    int insert(TplUserRole record);

    int insertSelective(TplUserRole record);

    List<TplUserRole> selectByExample(TplUserRoleExample example);

    int updateByExampleSelective(@Param("record") TplUserRole record, @Param("example") TplUserRoleExample example);

    int updateByExample(@Param("record") TplUserRole record, @Param("example") TplUserRoleExample example);
}