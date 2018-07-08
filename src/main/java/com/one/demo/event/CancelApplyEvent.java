package com.one.demo.event;

import com.one.demo.entity.ApplyTaskEntity;
import org.springframework.context.ApplicationEvent;

/**
 * 取消申请事件
 */
public class CancelApplyEvent extends ApplicationEvent{
    private Integer type;
    private ApplyTaskEntity taskEntity;
    private String userlable;
    private boolean isSuccess;

    public CancelApplyEvent(Object source, ApplyTaskEntity taskEntity) {
        super(source);
        this.taskEntity = taskEntity;
        this.userlable = taskEntity.getApplyReason();
    }

    public ApplyTaskEntity getTaskEntity() {
        return taskEntity;
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
