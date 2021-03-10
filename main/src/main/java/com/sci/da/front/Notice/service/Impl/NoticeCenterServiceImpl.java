package com.sci.da.front.Notice.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sci.da.front.Notice.entity.NoticeCenter;
import com.sci.da.front.Notice.mapper.NoticeCenterMapper;
import com.sci.da.front.Notice.service.NoticeCenterService;
import org.springframework.stereotype.Service;

@Service
public class NoticeCenterServiceImpl extends ServiceImpl<NoticeCenterMapper, NoticeCenter> implements NoticeCenterService {
}
