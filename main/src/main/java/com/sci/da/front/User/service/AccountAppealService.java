package com.sci.da.front.User.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sci.da.front.User.entity.AccountAppeal;

public interface AccountAppealService extends IService<AccountAppeal> {

    public void saveAccountAppeal(AccountAppeal accountAppeal);
}
