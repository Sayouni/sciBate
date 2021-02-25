package com.sci.da.front.Notice.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sci.da.front.Notice.Dto.NoticeDTO;
import com.sci.da.front.Notice.entity.Notice;
import com.sci.da.front.Notice.service.NoticeService;
import com.sci.da.main.util.ResponseTable;
import com.sci.da.main.util.TableResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
