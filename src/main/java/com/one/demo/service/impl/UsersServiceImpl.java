package com.one.demo.service.impl;

import com.one.demo.dao.UsersDao;
import com.one.demo.entity.UsersEntity;
import com.one.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    /**
     * 保存当前用户信息;
     *
     * @param usersEntity
     */
    @Override
    public void saveLoginUser(UsersEntity usersEntity) {

        usersDao.saveAndFlush(usersEntity);

    }
}
