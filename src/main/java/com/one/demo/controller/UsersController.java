package com.one.demo.controller;

import com.one.demo.dao.UsersDao;
import com.one.demo.entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UsersDao usersDao;

    @RequestMapping("/names")
    public String findAll(){
        List<UsersEntity> list = usersDao.findAll();
        return "ss";
    }
}
