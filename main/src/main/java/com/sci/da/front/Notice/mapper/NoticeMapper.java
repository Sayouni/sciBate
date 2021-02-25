package com.sci.da.front.Notice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sci.da.front.Notice.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeMapper extends BaseMapper<Notice> {

    List<Notice> selectNotice(Page page, @Param("noticeTitle") String noticeTitle, @Param("account") String account);

}
