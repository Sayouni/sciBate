package com.sci.da.front.Notice.service.Impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sci.da.front.Notice.dto.NoticeMsgDTO;
import com.sci.da.front.Notice.entity.Notice;
import com.sci.da.front.Notice.entity.NoticeCenter;
import com.sci.da.front.Notice.mapper.NoticeMapper;
import com.sci.da.front.Notice.service.NoticeCenterService;
import com.sci.da.front.Notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

    @Autowired
    private NoticeCenterService noticeCenterService;

    @Override
    public IPage<NoticeMsgDTO> selectNotice(Page page, String noticeTitle, String account) {
        List<NoticeMsgDTO> noticeList = baseMapper.selectNotice(page, noticeTitle, account);
        page.setRecords(noticeList);
        return page;
    }

    @Override
    public void changeReadStatus(String id) {
        baseMapper.updateReadStatus(id);
    }

    @Override
    @Transactional
    public boolean deleteNotice(List<String> idList) {
        if (idList.size() > 0) {
            List<String> noticeIdList = baseMapper.selectNoticeId(idList);
            //删除notice中数据
            baseMapper.deleteNoticeByIds(idList);
            baseMapper.deleteNoticeCenterByIds(noticeIdList);
            return true;

        }
        return true;
    }


}
