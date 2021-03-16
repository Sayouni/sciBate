package com.sci.da.front.Msg.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sci.da.front.Msg.dto.ManuscriptDTO;
import com.sci.da.front.Msg.dto.PersonalManuscriptDTO;
import com.sci.da.front.Msg.service.ManuscriptService;
import com.sci.da.main.util.ResponseMessage;
import com.sci.da.main.util.ResponseTable;
import com.sci.da.main.util.TableResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tianyuankuan
 * @since 2021-02-25
 */
@RestController
@RequestMapping("/manuscript")
@Api(tags = "稿件模块")
public class ManuscriptController {

    @Autowired
    private ManuscriptService manuscriptService;

    /**
     * page,limit,contributors,(manuscriptName)
     *
     * @param personalManuscriptDTO
     * @return
     */
    @GetMapping("/selectPersonalManuscript")
    @ApiOperation(value = "分页检索自己的稿件")
    public ResponseTable selectPersonalManuscript(PersonalManuscriptDTO personalManuscriptDTO) {
        if (StringUtils.isNotBlank(personalManuscriptDTO.getContributors())) {
            IPage<PersonalManuscriptDTO> result = manuscriptService.selectPersonalManuscript(new Page<>(
                            personalManuscriptDTO.getPage(), personalManuscriptDTO.getLimit()),
                    personalManuscriptDTO.getManuscriptName(), personalManuscriptDTO.getContributors());
            return TableResult.success("200", "查询成功", (int) result.getTotal(), result.getRecords());
        }
        return TableResult.error("500", "账号为空");
    }

    /**
     * page,limit,(manuscriptName)
     *
     * @param personalManuscriptDTO
     * @return
     */
    @GetMapping("/selectAllManuscript")
    @ApiOperation(value = "分页检索所有人的稿件")
    public ResponseTable selectAllManuscript(PersonalManuscriptDTO personalManuscriptDTO) {
        IPage<PersonalManuscriptDTO> result = manuscriptService.selectAllManuscript(new Page<>(
                        personalManuscriptDTO.getPage(), personalManuscriptDTO.getLimit()),
                personalManuscriptDTO.getManuscriptName());
        return TableResult.success("200", "查询成功", (int) result.getTotal(), result.getRecords());
    }


    /**
     * @param idList '稿件idList组'
     * @return
     */
    @DeleteMapping("/deleteManuscript")
    @ApiOperation("删除稿件单一/批量")
    public ResponseMessage deleteManuscript(@RequestParam(value = "idList", required = false) List<String> idList) {
        if (idList.size() > 0) {
            return ResponseMessage.createBySuccessCodeMessage("删除成功", manuscriptService.deleteManuscript(idList));
        }
        return ResponseMessage.createByErrorCodeMessage("500", "稿件Id为空");
    }

    /**
     * manuscriptDes,manuscriptKind,manuscriptName
     *
     * @param personalManuscriptDTO
     * @return
     */
    @PutMapping("/updateManuscript")
    @ApiOperation("修改稿件信息")
    public ResponseMessage updateManuscript(PersonalManuscriptDTO personalManuscriptDTO) {
        if (StringUtils.isNotBlank(personalManuscriptDTO.getId())) {
            if (manuscriptService.checkExistManuscript(personalManuscriptDTO.getId())) {
                if (manuscriptService.updateManuscript(personalManuscriptDTO)) {
                    return ResponseMessage.createBySuccessCodeMessage("信息修改成功", true);
                }
            }
            return ResponseMessage.createByErrorCodeMessage("500", "无此稿件");
        }
        return ResponseMessage.createByErrorCodeMessage("500", "稿件Id为空");
    }


    /**
     * contributors,manuscriptDes,manuscriptKind,manuscriptName,multipartFile
     *
     * @param manuscriptDTO
     * @param multipartFile
     * @return
     */
    @PostMapping("/uploadManuscript")
    @ApiOperation("稿件上传")
    public ResponseMessage uploadManuscript(ManuscriptDTO manuscriptDTO,
                                            @RequestParam("multipartFile") MultipartFile multipartFile) {
        if (multipartFile != null && multipartFile.getSize() > 0) {
            String fileName = multipartFile.getOriginalFilename();
            String format = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (!"pdf".equals(format) && !"doc".equals(format) && !"docx".equals(format)) {
                return ResponseMessage.createByErrorCodeMessage("500", "文稿仅支持pdf,doc,docx格式文件");
            }
            try {
                return ResponseMessage.createBySuccessCodeMessage("上传成功",
                        manuscriptService.uploadManuscript(manuscriptDTO, multipartFile));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseMessage.createByErrorCodeMessage("500", "上传失败");
            }
        }
        return ResponseMessage.createByErrorCodeMessage("500", "错误,未上传文件或上传了空文件");

    }

    @GetMapping("/downloadManuscript")
    @ApiOperation("稿件下载")
    public ResponseMessage downloadManuscript(HttpServletResponse response, HttpServletRequest request, String id
            , String contributors) {
        if (manuscriptService.checkMyselfManuscript(id, contributors)) {
            return ResponseMessage.createBySuccessCodeMessage("下载成功",
                    manuscriptService.downloadManuscript(response, request, id));
        }
        return ResponseMessage.createByErrorCodeMessage("500","该稿件公布，无法下载");

    }


}
