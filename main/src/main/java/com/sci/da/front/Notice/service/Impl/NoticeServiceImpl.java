package com.sci.da.front.Notice.service.Impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sci.da.front.Notice.entity.Notice;
import com.sci.da.front.Notice.mapper.NoticeMapper;
import com.sci.da.front.Notice.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

    @Override
    public IPage<Notice> selectNotice(Page page, String noticeTitle, String account) {
        List<Notice> noticeList = baseMapper.selectNotice(page, noticeTitle, account);
        page.setRecords(noticeList);
        return page;
    }
}
