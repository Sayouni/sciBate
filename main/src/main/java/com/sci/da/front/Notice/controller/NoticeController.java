package com.sci.da.front.Notice.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sci.da.front.Notice.Dto.NoticeDTO;
import com.sci.da.front.Notice.entity.Notice;
import com.sci.da.front.Notice.service.NoticeService;
import com.sci.da.main.util.ResponseMessage;
import com.sci.da.main.util.ResponseTable;
import com.sci.da.main.util.TableResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tianyuankuan
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/notice")
@Api(tags = "通知模块")
public class NoticeController {


    @Autowired
    private NoticeService noticeService;


    @GetMapping("/selectNotice")
    @ApiOperation(value = "通知分页检索")
    public ResponseTable selectNotice(NoticeDTO noticeDTO) {
        if (StringUtils.isNotBlank(noticeDTO.getAccount())) {
            IPage<Notice> result = noticeService.selectNotice(
                    new Page<>(noticeDTO.getPage(), noticeDTO.getLimit()), noticeDTO.getNoticeTitle(), noticeDTO.getAccount());
            return TableResult.success("200", "查询成功", (int) result.getTotal(), result.getRecords());
        } else {
            return TableResult.error("500", "账号为空");
        }
    }

    /**
     * 需要参数id,account
     * @param Id
     * @return
     */
    @PutMapping("/changeReadStatus")
    @ApiOperation(value = "修改阅读状态为已读")
    public ResponseMessage changeReadStatus(String Id){
            if (StringUtils.isNotBlank(Id)){
                noticeService.changeReadStatus(Id);
                return ResponseMessage.createBySuccessMessage("修改成功");
            }
            return ResponseMessage.createByErrorMessage("错误，通知ID为空");

    }

    @DeleteMapping("/deleteNotice")
    @ApiOperation(value = "删除通知")
    public ResponseMessage deleteNotice(String Id){
        if (StringUtils.isNotBlank(Id)){
            noticeService.deleteNotice(Id);
            return ResponseMessage.createBySuccessMessage("删除成功");
        }
        return ResponseMessage.createByErrorMessage("错误，通知ID为空");
    }



}
