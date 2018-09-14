package com.app.tpl.service.dao.mapper.db;

import com.app.tpl.service.dao.model.db.TplRolePrivilege;
import com.app.tpl.service.dao.model.db.TplRolePrivilegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TplRolePrivilegeMapper {
    int countByExample(TplRolePrivilegeExample example);

    int deleteByExample(TplRolePrivilegeExample example);

    int insert(TplRolePrivilege record);

    int insertSelective(TplRolePrivilege record);

    List<TplRolePrivilege> selectByExample(TplRolePrivilegeExample example);

    int updateByExampleSelective(@Param("record") TplRolePrivilege record, @Param("example") TplRolePrivilegeExample example);

    int updateByExample(@Param("record") TplRolePrivilege record, @Param("example") TplRolePrivilegeExample example);
}