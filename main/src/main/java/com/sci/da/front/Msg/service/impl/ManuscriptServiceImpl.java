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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
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

    @Override
    public boolean checkMyselfManuscript(String id, String contributors) {
        String idColumn = "id";
        List<Manuscript> resList = baseMapper.selectList(new QueryWrapper<Manuscript>().in(idColumn,id));
        for (Manuscript manuscript : resList){
            if (manuscript.getAuditStatus()==1){
                return true;
            }else {
                if (manuscript.getContributors().contains(contributors)){
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public boolean downloadManuscript(HttpServletResponse response, HttpServletRequest request, String id) {
        String idColumn = "id";
        Manuscript manuscript = baseMapper.selectOne(new QueryWrapper<Manuscript>().in(idColumn,id));
        try {
            //文件地址
            File file = new File(manuscript.getManuscriptTitle());
            // 穿件输入对象
            FileInputStream fis = new FileInputStream(file);
            // 设置相关格式
            response.setContentType("application/force-download");
            // 设置下载后的文件名以及header
            String fileName = new String(manuscript.getIdentifyingName().getBytes("utf-8"),"iso-8859-1");
            response.addHeader("Content-disposition", "attachment;fileName=" + fileName);
            // 创建输出对象
            OutputStream os = response.getOutputStream();
            // 常规操作
            byte[] buf = new byte[1024];
            int len = 0;
            while((len = fis.read(buf)) != -1) {
                os.write(buf, 0, len);
            }
            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }
}
