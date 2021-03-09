package com.sci.da.background.ReviewManuscript.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sci.da.front.Msg.dto.ManuscriptDTO;
import com.sci.da.front.Msg.entity.Manuscript;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReviewManuscriptMapper extends BaseMapper<Manuscript> {

    List<ManuscriptDTO> getManuscriptMsg(Page page, @Param("manuscriptDTO") ManuscriptDTO manuscriptDTO);

}
