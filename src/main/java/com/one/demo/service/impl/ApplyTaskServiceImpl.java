package com.one.demo.service.impl;

import com.one.demo.dao.ApplyDao;
import com.one.demo.dao.ApplyTaskDao;
import com.one.demo.entity.ApplyEntity;
import com.one.demo.entity.ApplyTaskEntity;
import com.one.demo.event.CancelApplyEvent;
import com.one.demo.event.CheckApplyEvent;
import com.one.demo.service.ApplyTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplyTaskServiceImpl implements ApplyTaskService {

    @Autowired
    private ApplyTaskDao applyTaskDao;
    @Autowired
    private ApplyDao applyDao;
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Override
    public List<ApplyTaskEntity> findAll(Long applyId) {
         return applyTaskDao.findByApplyId(applyId);
    }

    /**
     * 审核申请
     *
     * @param taskEntity
     */
    @Override
    public void checkApply(ApplyTaskEntity taskEntity, int actionType) {
        taskEntity  = applyTaskDao.findById(taskEntity.getId()).orElse(null);
        // 区分类型 申请审核\ 延期审核\ 归还审核
        CheckApplyEvent applyEvent = new CheckApplyEvent(this, taskEntity, actionType);
        eventPublisher.publishEvent(applyEvent);
        if( !applyEvent.isSuccess() ){
            throw  new RuntimeException("操作失败");
        }
    }

    /**
     * 取消申请
     *
     * @param taskEntity
     */
    @Override
    public void cancelApply(ApplyTaskEntity taskEntity) {
        taskEntity  = applyTaskDao.findById(taskEntity.getId()).orElse(null);
        // 区分类型 申请取消\ 延期取消\ 归还取消
        CancelApplyEvent applyEvent = new CancelApplyEvent(this, taskEntity);
        eventPublisher.publishEvent(applyEvent);
        if( !applyEvent.isSuccess() ){
            throw  new RuntimeException("操作失败");
        }
    }

    /**
     * 领取
     *
     * @param taskEntity
     */
    @Override
    @Transactional
    public void getApply(ApplyTaskEntity taskEntity) {
        taskEntity  = applyTaskDao.findById(taskEntity.getId()).orElse(null);
        ApplyEntity applyEntity = null;

        if (taskEntity.borrowPullStatus() ){
            taskEntity.borrowPull();
            applyTaskDao.saveAndFlush(taskEntity);
            applyEntity = applyDao.findById(taskEntity.getApplyId()).orElse(null);
            applyEntity.borrowFinishPull();
            applyDao.saveAndFlush(applyEntity);
        }else{
            throw new RuntimeException("状态不正确");
        }

    }
}
