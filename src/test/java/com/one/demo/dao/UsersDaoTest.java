package com.one.demo.dao;

import com.one.demo.entity.UsersEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UsersDaoTest {

    @Autowired
    private UsersDao usersDao;

    @Test
    public void saveTest(){
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setCode("xxxxxx");
        usersEntity.setLastDate("xfdfdff");
        usersEntity.setName("dd 丢到");
        usersEntity.setType(1L);
        usersDao.save(usersEntity);
    }
}