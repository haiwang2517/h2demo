package com.one.demo.service;

import com.one.demo.entity.UsersEntity;

public interface UsersService {

    /**
     * 保存当前用户信息;
     */
    void saveLoginUser(UsersEntity usersEntity);

}
