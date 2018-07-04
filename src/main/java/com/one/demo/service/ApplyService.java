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
     * 借阅申请
     * @param entity
     */
    void borrowApply( ApplyEntity entity );

    /**
     * 延期申请
     * @param entity
     */
    void lazyApply( ApplyEntity entity );

    /**
     * 归还申请
     * @param entity
     */
    void backApply( ApplyEntity entity );

}
