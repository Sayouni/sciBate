package com.sci.da.front.Msg.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sci.da.front.Msg.dto.ManuscriptDTO;
import com.sci.da.front.Msg.dto.PersonalManuscriptDTO;
import com.sci.da.front.Msg.entity.Manuscript;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ManuscriptService extends IService<Manuscript> {

    IPage<PersonalManuscriptDTO> selectPersonalManuscript(Page page,String manuscriptName ,String account);

    IPage<PersonalManuscriptDTO> selectAllManuscript(Page page, String manuscriptName);

    boolean deleteManuscript(List<String> idList);

    boolean updateManuscript(PersonalManuscriptDTO personalManuscriptDTO);

    boolean checkExistManuscript(String id);

    boolean uploadManuscript(ManuscriptDTO manuscriptDTO, MultipartFile multipartFile);

    boolean checkMyselfManuscript(String id, String contributors);

    boolean downloadManuscript(HttpServletResponse response, HttpServletRequest request, String id);

}
