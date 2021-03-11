package com.sci.da.background.ManagerNotice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sci.da.background.ManagerNotice.dto.GroupCenterMsgDTO;
import com.sci.da.background.ManagerNotice.dto.NoticePublishDTO;
import com.sci.da.front.Notice.dto.NoticeCenterDTO;
import com.sci.da.front.Notice.entity.Notice;

import java.util.List;

public interface ManagerNoticeService extends IService<Notice> {


    boolean sendNotice(NoticePublishDTO noticePublishDTO);


    boolean revokeNotice(List<String> noticeIdList);

    IPage<NoticeCenterDTO> getSendNotice(Page page, NoticeCenterDTO noticeCenterDTO);

}
