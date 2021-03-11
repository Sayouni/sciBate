package com.sci.da.background.ManagerNotice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sci.da.background.ManagerNotice.dto.GroupCenterMsgDTO;
import com.sci.da.front.Notice.dto.NoticeCenterDTO;
import com.sci.da.front.Notice.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerNoticeMapper extends BaseMapper<Notice> {

    List<NoticeCenterDTO> getSendNotice(Page page,@Param("noticeCenterDTO") NoticeCenterDTO noticeCenterDTO);

    boolean revokeNotice(@Param("noticeIdList") List<String> noticeIdList);

}
