package com.sci.da.front.Msg.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sci.da.front.Msg.Dto.PersonalManuscriptDTO;
import com.sci.da.front.Msg.entity.Manuscript;
import com.sci.da.front.Msg.mapper.ManuscriptMapper;
import com.sci.da.front.Msg.service.ManuscriptService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManuscriptServiceImpl extends ServiceImpl<ManuscriptMapper, Manuscript> implements ManuscriptService {


    @Override
    public IPage<PersonalManuscriptDTO> selectPersonalManuscript(Page page, String manuscriptName, String account) {
        List<PersonalManuscriptDTO> resultList = baseMapper.selectPersonalManuscript(page, manuscriptName, account);
        page.setRecords(resultList);
        return page;
    }

    @Override
    public IPage<PersonalManuscriptDTO> selectAllManuscript(Page page, String manuscriptName) {
        List<PersonalManuscriptDTO> resultList = baseMapper.selectAllManuscript(page,manuscriptName);
        page.setRecords(resultList);
        return page;
    }
}
