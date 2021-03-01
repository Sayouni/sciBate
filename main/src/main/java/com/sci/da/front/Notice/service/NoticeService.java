package com.sci.da.front.Notice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sci.da.front.Notice.entity.Notice;

public interface NoticeService extends IService<Notice> {

    IPage<Notice> selectNotice(Page page, String noticeTitle, String account);

    void changeReadStatus(String Id);

    void deleteNotice(String id);

}
