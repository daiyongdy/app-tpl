package com.app.tpl.service.dao.mapper.db;

import com.app.tpl.service.dao.model.db.TplRole;
import com.app.tpl.service.dao.model.db.TplRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TplRoleMapper {
    int countByExample(TplRoleExample example);

    int deleteByExample(TplRoleExample example);

    int deleteByPrimaryKey(Long roleId);

    int insert(TplRole record);

    int insertSelective(TplRole record);

    List<TplRole> selectByExample(TplRoleExample example);

    TplRole selectByPrimaryKey(Long roleId);

    int updateByExampleSelective(@Param("record") TplRole record, @Param("example") TplRoleExample example);

    int updateByExample(@Param("record") TplRole record, @Param("example") TplRoleExample example);

    int updateByPrimaryKeySelective(TplRole record);

    int updateByPrimaryKey(TplRole record);
}