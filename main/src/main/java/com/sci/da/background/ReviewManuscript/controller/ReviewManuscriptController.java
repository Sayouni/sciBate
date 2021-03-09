package com.sci.da.background.ReviewManuscript.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sci.da.background.ReviewManuscript.service.ReviewManuscriptService;
import com.sci.da.front.Msg.dto.ManuscriptDTO;
import com.sci.da.front.Msg.dto.PersonalManuscriptDTO;
import com.sci.da.main.util.ResponseMessage;
import com.sci.da.main.util.ResponseTable;
import com.sci.da.main.util.TableResult;
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


}
