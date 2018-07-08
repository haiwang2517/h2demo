package com.one.demo.service.impl;

import com.one.demo.dao.MessageDao;
import com.one.demo.entity.ApplyTaskEntity;
import com.one.demo.entity.MessagesEntity;
import com.one.demo.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagesServiceImpl implements MessagesService {

    @Autowired
    private MessageDao messageDao;
    /**
     * 发送消息通知
     * @param taskEntity
     */
    @Override
    public void sendMessage(ApplyTaskEntity taskEntity) {

        MessagesEntity entity = null;  // TODO 通过工厂进行转换

        messageDao.save(entity);

        //TODO 调用小程序API 发送通知提醒
    }
}
