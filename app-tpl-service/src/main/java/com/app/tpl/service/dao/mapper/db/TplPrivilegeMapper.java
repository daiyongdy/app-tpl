package com.app.tpl.service.dao.mapper.db;

import com.app.tpl.service.dao.model.db.TplPrivilege;
import com.app.tpl.service.dao.model.db.TplPrivilegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TplPrivilegeMapper {
    int countByExample(TplPrivilegeExample example);

    int deleteByExample(TplPrivilegeExample example);

    int deleteByPrimaryKey(Long privilegeId);

    int insert(TplPrivilege record);

    int insertSelective(TplPrivilege record);

    List<TplPrivilege> selectByExample(TplPrivilegeExample example);

    TplPrivilege selectByPrimaryKey(Long privilegeId);

    int updateByExampleSelective(@Param("record") TplPrivilege record, @Param("example") TplPrivilegeExample example);

    int updateByExample(@Param("record") TplPrivilege record, @Param("example") TplPrivilegeExample example);

    int updateByPrimaryKeySelective(TplPrivilege record);

    int updateByPrimaryKey(TplPrivilege record);
}