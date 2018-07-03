package com.one.demo.service;

import com.one.demo.entity.ApplyEntity;

public interface ApplyService {

    /**
     * 申请
     * @param applyEntity
     */
    void apply(ApplyEntity applyEntity);

    /**
     * 审核
     * @param applyEntity
     */
    void check(ApplyEntity applyEntity);

    /**
     * 登记
     * @param applyEntity
     */
    void register(ApplyEntity applyEntity);
    /**
     * 查询
     * @param applyEntity
     */
    void findApply(ApplyEntity applyEntity);

}
