package com.sci.da.background.ReviewManuscript.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sci.da.background.ReviewManuscript.mapper.ReviewManuscriptMapper;
import com.sci.da.background.ReviewManuscript.service.ReviewManuscriptService;
import com.sci.da.front.Msg.dto.ManuscriptDTO;
import com.sci.da.front.Msg.entity.Manuscript;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewManuscriptServiceImpl extends ServiceImpl<ReviewManuscriptMapper, Manuscript> implements ReviewManuscriptService {


    @Override
    public List<ManuscriptDTO> getManuscriptMsg(ManuscriptDTO manuscriptDTO) {
        List<ManuscriptDTO> resList = baseMapper.getManuscriptMsg(manuscriptDTO);
        return resList;
    }

    @Override
    public boolean editAuditStatus(ManuscriptDTO manuscriptDTO) {
        Manuscript manuscript = Manuscript.builder().build();
        BeanUtil.copyProperties(manuscriptDTO,manuscript);
        if (saveOrUpdate(manuscript)){
            return true;
        }
        return false;
    }
}
