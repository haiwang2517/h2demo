package com.one.demo.service;

import com.one.demo.entity.ApplyTaskEntity;

/**
 * 消息服务
 */
public interface MessagesService {

    /**
     * 发送消息通知
     * @param taskEntity
     */
    void sendMessage(ApplyTaskEntity taskEntity);
}
