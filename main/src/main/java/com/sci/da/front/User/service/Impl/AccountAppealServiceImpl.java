package com.sci.da.front.User.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sci.da.front.User.entity.AccountAppeal;
import com.sci.da.front.User.mapper.AccountAppealMapper;
import com.sci.da.front.User.service.AccountAppealService;
import org.springframework.stereotype.Service;

@Service
public class AccountAppealServiceImpl extends ServiceImpl<AccountAppealMapper, AccountAppeal> implements AccountAppealService {

    @Override
    public void saveAccountAppeal(AccountAppeal accountAppeal) {
        baseMapper.insert(accountAppeal);
    }
}
