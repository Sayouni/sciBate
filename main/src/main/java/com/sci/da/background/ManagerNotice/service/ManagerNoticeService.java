package com.sci.da.background.ManagerNotice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sci.da.background.ManagerNotice.dto.NoticePublishDTO;
import com.sci.da.front.Notice.entity.Notice;

public interface ManagerNoticeService extends IService<Notice> {


    boolean sendNotice(NoticePublishDTO noticePublishDTO);

}
