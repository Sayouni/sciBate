package com.sci.da.front.User.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sci.da.front.User.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserInfoMapper extends BaseMapper<UserInfo> {

    @Select("select enable_status from USER_INFO where USER_INFO.account = #{account}")
    Integer checkStatus(@Param("account") String account);
}
