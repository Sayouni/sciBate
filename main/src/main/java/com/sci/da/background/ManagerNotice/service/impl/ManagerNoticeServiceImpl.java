package com.sci.da.background.ManagerNotice.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sci.da.background.ManagerNotice.dto.GroupCenterMsgDTO;
import com.sci.da.background.ManagerNotice.dto.NoticePublishDTO;
import com.sci.da.background.ManagerNotice.mapper.ManagerNoticeMapper;
import com.sci.da.background.ManagerNotice.service.ManagerNoticeService;
import com.sci.da.front.Notice.dto.NoticeCenterDTO;
import com.sci.da.front.Notice.entity.Notice;
import com.sci.da.front.Notice.entity.NoticeCenter;
import com.sci.da.front.Notice.service.NoticeCenterService;
import com.sci.da.main.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class ManagerNoticeServiceImpl extends ServiceImpl<ManagerNoticeMapper, Notice> implements ManagerNoticeService {

    @Value("${snowflake.worker.id}")
    private Long workerId;
    @Value("${snowflake.data.center.id}")
    private Long dataCenterId;


    @Autowired
    private NoticeCenterService noticeCenterService;

    @Override
    @Transactional
    public boolean sendNotice(NoticePublishDTO noticePublishDTO) {

        List<Notice> noticeList = new ArrayList<>();

        //通知id
        String noticeId = String.valueOf(IdUtil.getId(workerId,dataCenterId));

        //创建通知
        NoticeCenter noticeCenter = NoticeCenter.builder()
                .id(noticeId)
                .noticeTitle(noticePublishDTO.getNoticeTitle())
                .noticeDetail(noticePublishDTO.getNoticeDetail())
                .publishManager(noticePublishDTO.getPublishManager()).build();

        for (String idList : noticePublishDTO.getUserList()){
            Notice notice = Notice.builder()
                    .id(String.valueOf(IdUtil.getId(workerId,dataCenterId)))
                    .account(idList)
                    .noticeId(noticeId).build();
            noticeList.add(notice);
        }

        if (saveBatch(noticeList)){
            noticeCenterService.save(noticeCenter);
            return true;
        }

        return false;
    }

    @Override
    public boolean revokeNotice(List<String> noticeIdList) {
        if (noticeIdList.size()>0) {
            if (baseMapper.revokeNotice(noticeIdList)) {
                return true;
            }
            return false;
        }
        return true;
    }

    @Override
    public IPage<NoticeCenterDTO> getSendNotice(Page page, NoticeCenterDTO noticeCenterDTO) {
        List<NoticeCenterDTO> resultList = baseMapper.getSendNotice(page,noticeCenterDTO);
        page.setRecords(resultList);
        return page;
    }
}
