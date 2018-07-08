package com.one.demo.service;

import com.one.demo.entity.ApplyEntity;
import com.one.demo.entity.ApplyTaskEntity;

import java.util.List;

public interface ApplyTaskService {

    List<ApplyTaskEntity> findAll(Long applyId);

    /**
     * 审核申请
     * @param taskEntity
     * @param actionType  1 审核通过 0 : 审核不通过
     */
    void checkApply(ApplyTaskEntity taskEntity, int actionType);

    /**
     * 取消申请
     * @param taskEntity
     */
    void cancelApply(ApplyTaskEntity taskEntity);

    /**
     * 领取
     * @param taskEntity
     */
    void getApply( ApplyTaskEntity taskEntity);

}
