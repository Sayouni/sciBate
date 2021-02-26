package com.sci.da.front.Msg.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sci.da.front.Msg.Dto.PersonalManuscriptDTO;
import com.sci.da.front.Msg.entity.Manuscript;

public interface ManuscriptService extends IService<Manuscript> {

    IPage<PersonalManuscriptDTO> selectPersonalManuscript(Page page,String manuscriptName ,String account);

}
