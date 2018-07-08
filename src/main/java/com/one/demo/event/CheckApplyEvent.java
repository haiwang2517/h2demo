package com.one.demo.event;

import com.one.demo.entity.ApplyTaskEntity;
import org.springframework.context.ApplicationEvent;

/**
 * 审核申请事件
 */
public class CheckApplyEvent extends ApplicationEvent {
    private ApplyTaskEntity taskEntity;
    private Integer actionType;
    private String userlable;
    private boolean isSuccess;

    public CheckApplyEvent(Object source, ApplyTaskEntity taskEntity, Integer actionType) {
        super(source);
        this.taskEntity = taskEntity;
        this.actionType  = actionType;
        this.userlable = taskEntity.getApplyReason();
    }

    public ApplyTaskEntity getTaskEntity() {
        return taskEntity;
    }

    public Integer getActionType() {
        return actionType;
    }

    public String getUserlable() {
        return userlable;
    }

    public void exeSuccess(){
        this.isSuccess = true;
    }
    public boolean isSuccess() {
        return isSuccess;
    }
}
