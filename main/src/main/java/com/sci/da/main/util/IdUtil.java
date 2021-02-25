package com.sci.da.main.util;

import cn.hutool.core.lang.Snowflake;

/**
 * 雪花算法Id生成器
 */
public class IdUtil {

    private static Snowflake snowflake;

    public static Long getId(Long workerId, Long dataCenterId) {
        if(snowflake == null) {
            snowflake = cn.hutool.core.util.IdUtil.createSnowflake(workerId, dataCenterId);
        }
        return snowflake.nextId();
    }
}