package com.sci.da.front.Msg.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sci.da.front.Msg.Dto.ManuscriptDTO;
import com.sci.da.front.Msg.Dto.PersonalManuscriptDTO;
import com.sci.da.front.Msg.entity.Manuscript;
import com.sci.da.front.Msg.mapper.ManuscriptMapper;
import com.sci.da.front.Msg.service.ManuscriptService;
import com.sci.da.main.util.IdUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ManuscriptServiceImpl extends ServiceImpl<ManuscriptMapper, Manuscript> implements ManuscriptService {

    @Value("${snowflake.worker.id}")
    private Long workerId;

    @Value("${snowflake.data.center.id}")
    private Long dataCenterId;

    @Value("${manuscript.file.path}")
    private String manuscriptPath;


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

    @Override
    public boolean deleteManuscript(List<String> idList) {
        if (baseMapper.deleteBatchIds(idList)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateManuscript(PersonalManuscriptDTO personalManuscriptDTO) {
        Manuscript manuscript = Manuscript.builder().build();
        BeanUtil.copyProperties(personalManuscriptDTO,manuscript);
        if (baseMapper.updateById(manuscript)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkExistManuscript(String id) {
        String columnId = "id";
        if (baseMapper.selectList(new QueryWrapper<Manuscript>().in(columnId,id)).size()>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean uploadManuscript(ManuscriptDTO manuscriptDTO, MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        String filePath = manuscriptPath;
        String identifyingName = String.valueOf(IdUtil.getId(workerId,dataCenterId));
        String saveFilePathName = filePath+"/"+identifyingName;
        File dest = new File(saveFilePathName);
        if (!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        try {
            multipartFile.transferTo(dest);
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        manuscriptDTO.setId(String.valueOf(IdUtil.getId(workerId,dataCenterId)));
        manuscriptDTO.setManuscriptTitle(saveFilePathName);
        manuscriptDTO.setIdentifyingName(fileName);
        Manuscript manuscript = Manuscript.builder().build();
        BeanUtil.copyProperties(manuscriptDTO,manuscript);
        save(manuscript);
        return true;
    }
}
