package com.sci.da.front.Msg.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sci.da.front.Msg.Dto.PersonalManuscriptDTO;
import com.sci.da.front.Msg.service.ManuscriptService;
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
     * @param personalManuscriptDTO
     * @return
     */
    @GetMapping("/selectPersonalManuscript")
    @ApiOperation(value = "分页检索自己的稿件")
    public ResponseTable selectPersonalManuscript(PersonalManuscriptDTO personalManuscriptDTO) {
        if (StringUtils.isNotBlank(personalManuscriptDTO.getContributors())) {
            IPage<PersonalManuscriptDTO> result = manuscriptService.selectPersonalManuscript(new Page<>(
                    personalManuscriptDTO.getPage(), personalManuscriptDTO.getLimit()),
                    personalManuscriptDTO.getManuscriptName(),personalManuscriptDTO.getContributors());
            return TableResult.success("200", "查询成功", (int) result.getTotal(), result.getRecords());
        }
        return TableResult.error("500", "账号为空");
    }


}
