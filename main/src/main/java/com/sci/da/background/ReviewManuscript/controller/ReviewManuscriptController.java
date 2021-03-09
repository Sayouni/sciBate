package com.sci.da.background.ReviewManuscript.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sci.da.background.ReviewManuscript.service.ReviewManuscriptService;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/reviewManuscript")
@Api(tags = "稿件审理模块")
public class ReviewManuscriptController {

    @Autowired
    private ReviewManuscriptService reviewManuscriptService;

    @Autowired
    private ManuscriptService manuscriptService;

    /**
     * contributors创作者，manuscriptName标题名称,manuscriptKind分类.auditStatus审理状态,page,limit
     *
     * @param manuscriptDTO
     * @return
     */
    @GetMapping("/getManuscriptMsg")
    @ApiOperation("获取稿件列表")
    public ResponseTable getManuscriptMsg(ManuscriptDTO manuscriptDTO, Integer page, Integer limit) {
        IPage<ManuscriptDTO> result = reviewManuscriptService.getManuscriptMsg(new Page<>(
                        page,limit), manuscriptDTO);
        return TableResult.success("200", "查询成功", (int) result.getTotal(), result.getRecords());
    }

    /**
     * id,auditStatus
     *
     * @param manuscriptDTO
     * @return
     */
    @PutMapping("/editAuditStatus")
    @ApiOperation("修改审核状态")
    public ResponseMessage editAuditStatus(ManuscriptDTO manuscriptDTO) {
        if (StringUtils.isNotBlank(manuscriptDTO.getId())) {
            if (reviewManuscriptService.editAuditStatus(manuscriptDTO)) {
                return ResponseMessage.createBySuccessMessage("修改成功");
            }
            return ResponseMessage.createByErrorMessage("修改失败");
        }
        return ResponseMessage.createByErrorMessage("缺少参数");
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
        return ResponseMessage.createByErrorCodeMessage(500, "稿件Id为空");
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
            return ResponseMessage.createByErrorCodeMessage(500, "无此稿件");
        }
        return ResponseMessage.createByErrorCodeMessage(500, "稿件Id为空");
    }

    @GetMapping("/downloadManuscript")
    @ApiOperation("稿件下载")
    public ResponseMessage downloadManuscript(HttpServletResponse response, HttpServletRequest request, String id
            , String contributors) {
            return ResponseMessage.createBySuccessCodeMessage("下载成功",
                    manuscriptService.downloadManuscript(response, request, id));

    }




}
