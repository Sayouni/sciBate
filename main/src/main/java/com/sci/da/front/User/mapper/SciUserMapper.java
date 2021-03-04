package com.sci.da.front.User.mapper;

import com.sci.da.front.User.dto.UserMsgDTO;
import com.sci.da.front.User.entity.AccountAppeal;
import com.sci.da.front.User.entity.SciUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tianyuankuan
 * @since 2021-02-01
 */
public interface SciUserMapper extends BaseMapper<SciUser> {

    @Select("select user_login_name from SCI_USER")
    List<String> selectAccounts();

    UserMsgDTO getUserInfo(@Param("account") String account);
}
