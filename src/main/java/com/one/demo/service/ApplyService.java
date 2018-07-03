package com.one.demo.service;

import com.one.demo.entity.ApplyEntity;
import com.one.demo.service.finder.ApplyFinder;

import java.util.List;

/**
 * 申请服务
 */
public interface ApplyService {

    /**
     * 查询申请列表
     * @param finder
     * @return
     */
    List<ApplyEntity> findAll(ApplyFinder finder);

    /**
     * 借阅申请、归还申请、延期申请
     * @param entity
     */
    void apply( ApplyEntity entity );

    /**
     * 借阅审核、归还确认、延期确认
     * @param entity
     */
    void checkApply( ApplyEntity entity );

    /**
     * 领取
     * @param entity
     */
    void getApply( ApplyEntity entity );
}
