package com.app.tpl.service.dao.mapper.db;

import com.app.tpl.service.dao.model.db.TplNotice;
import com.app.tpl.service.dao.model.db.TplNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TplNoticeMapper {
    int countByExample(TplNoticeExample example);

    int deleteByExample(TplNoticeExample example);

    int deleteByPrimaryKey(Long noticeId);

    int insert(TplNotice record);

    int insertSelective(TplNotice record);

    List<TplNotice> selectByExample(TplNoticeExample example);

    TplNotice selectByPrimaryKey(Long noticeId);

    int updateByExampleSelective(@Param("record") TplNotice record, @Param("example") TplNoticeExample example);

    int updateByExample(@Param("record") TplNotice record, @Param("example") TplNoticeExample example);

    int updateByPrimaryKeySelective(TplNotice record);

    int updateByPrimaryKey(TplNotice record);
}