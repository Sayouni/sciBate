package com.sci.da.background.ReviewManuscript.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sci.da.front.Msg.dto.ManuscriptDTO;
import com.sci.da.front.Msg.entity.Manuscript;

import java.util.List;

public interface ReviewManuscriptService extends IService<Manuscript> {

    IPage<ManuscriptDTO> getManuscriptMsg(Page page, ManuscriptDTO manuscriptDTO);

    boolean editAuditStatus(ManuscriptDTO manuscriptDTO);

}
