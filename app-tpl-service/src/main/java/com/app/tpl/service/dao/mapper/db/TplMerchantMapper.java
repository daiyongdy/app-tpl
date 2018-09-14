package com.app.tpl.service.dao.mapper.db;

import com.app.tpl.service.dao.model.db.TplMerchant;
import com.app.tpl.service.dao.model.db.TplMerchantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TplMerchantMapper {
    int countByExample(TplMerchantExample example);

    int deleteByExample(TplMerchantExample example);

    int deleteByPrimaryKey(Long merchantId);

    int insert(TplMerchant record);

    int insertSelective(TplMerchant record);

    List<TplMerchant> selectByExample(TplMerchantExample example);

    TplMerchant selectByPrimaryKey(Long merchantId);

    int updateByExampleSelective(@Param("record") TplMerchant record, @Param("example") TplMerchantExample example);

    int updateByExample(@Param("record") TplMerchant record, @Param("example") TplMerchantExample example);

    int updateByPrimaryKeySelective(TplMerchant record);

    int updateByPrimaryKey(TplMerchant record);
}