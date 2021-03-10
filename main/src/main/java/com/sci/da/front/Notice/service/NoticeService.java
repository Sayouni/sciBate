package com.sci.da.front.Notice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sci.da.front.Notice.dto.NoticeMsgDTO;
import com.sci.da.front.Notice.entity.Notice;

import java.util.List;

public interface NoticeService extends IService<Notice> {

    IPage<NoticeMsgDTO> selectNotice(Page page, String noticeTitle, String account);

    void changeReadStatus(String Id);

    boolean deleteNotice(List<String> id);

}
