package com.one.demo.listener;

import com.one.demo.dao.ApplyDao;
import com.one.demo.dao.ApplyTaskDao;
import com.one.demo.entity.ApplyEntity;
import com.one.demo.event.CancelApplyEvent;
import com.one.demo.event.CheckApplyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LazyListener {

    @Autowired
    private ApplyTaskDao taskDao;
    @Autowired
    private ApplyDao applyDao;

    @Transactional
    @EventListener
    public void checkListenerHandel(CheckApplyEvent checkApplyEvent){
        if(!checkApplyEvent.getTaskEntity().lazyCheckStatus()){
            return;
        }
        ApplyEntity applyEntity = applyDao.findById(checkApplyEvent.getTaskEntity().getApplyId()).orElse(null);

        if( checkApplyEvent.getActionType() == 1 ){ // 审核通过
            checkApplyEvent.getTaskEntity().checkSuccess(checkApplyEvent.getUserlable());
            applyEntity.lazyFinish();
        }else if ( checkApplyEvent.getActionType() == 2 ){ //审核不通过
            checkApplyEvent.getTaskEntity().checkFault(checkApplyEvent.getUserlable(),"申请图书不能延期");
            applyEntity.lazyCancel();
        } else{
            throw new RuntimeException("数据状态不正确不能审核");
        }

        taskDao.saveAndFlush(checkApplyEvent.getTaskEntity());
        applyDao.saveAndFlush(applyEntity);
        checkApplyEvent.exeSuccess();
    }

    @Transactional
    @EventListener
    public void cancelListenerHandel(CancelApplyEvent cancelApplyEvent) {
        if(!cancelApplyEvent.getTaskEntity().lazyCheckStatus()){
            return;
        }
        ApplyEntity applyEntity = applyDao.findById(cancelApplyEvent.getTaskEntity().getApplyId()).orElse(null);

        cancelApplyEvent.getTaskEntity().checkCancel(cancelApplyEvent.getUserlable(), "自动取消");

        applyEntity.lazyCancel();

        taskDao.saveAndFlush(cancelApplyEvent.getTaskEntity());
        applyDao.saveAndFlush(applyEntity);
        cancelApplyEvent.exeSuccess();
    }
}
