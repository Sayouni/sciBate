package com.sci.da.front.Msg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sci.da.front.Msg.Dto.PersonalManuscriptDTO;
import com.sci.da.front.Msg.entity.Manuscript;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManuscriptMapper extends BaseMapper<Manuscript> {

    List<PersonalManuscriptDTO> selectPersonalManuscript(Page page, @Param("manuscriptName") String manuscriptName, @Param("account") String account);

    List<PersonalManuscriptDTO> selectAllManuscript(Page page, @Param("manuscriptName") String manuscriptName);

}
