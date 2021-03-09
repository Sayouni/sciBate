package com.sci.da.background.ReviewManuscript.controller;


import com.sci.da.background.ReviewManuscript.service.ReviewManuscriptService;
import com.sci.da.front.Msg.dto.ManuscriptDTO;
import com.sci.da.main.util.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviewManuscript")
@Api(tags = "稿件审理模块")
public class ReviewManuscriptController {

    @Autowired
    private ReviewManuscriptService reviewManuscriptService;

    /**
     * contributors创作者，manuscriptName标题名称,manuscriptKind分类.auditStatus审理状态
     * @param manuscriptDTO
     * @return
     */
    @GetMapping("/getManuscriptMsg")
    @ApiOperation("获取稿件列表")
    public ResponseMessage getManuscriptMsg(ManuscriptDTO manuscriptDTO){
        return ResponseMessage.createBySuccessCodeMessage("查询成功",reviewManuscriptService.getManuscriptMsg(manuscriptDTO));
    }

    /**
     * id,auditStatus
     * @param manuscriptDTO
     * @return
     */
    @PutMapping("/editAuditStatus")
    @ApiOperation("修改审核状态")
    public ResponseMessage editAuditStatus(ManuscriptDTO manuscriptDTO){
        if(StringUtils.isNotBlank(manuscriptDTO.getId())) {
            if (reviewManuscriptService.editAuditStatus(manuscriptDTO)) {
                return ResponseMessage.createBySuccessMessage("修改成功");
            }
            return ResponseMessage.createByErrorMessage("修改失败");
        }
        return ResponseMessage.createByErrorMessage("缺少参数");
    }





}
