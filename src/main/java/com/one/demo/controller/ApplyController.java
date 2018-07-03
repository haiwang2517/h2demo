package com.one.demo.controller;

import com.one.demo.entity.ApplyEntity;
import com.one.demo.service.ApplyService;
import com.one.demo.service.finder.ApplyFinder;
import com.one.demo.utils.ViewResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplyController {
    private Logger logger = LoggerFactory.getLogger(ApplyController.class);

    @Autowired
    private ApplyService applyService;

    /**
     * 查询申请信息
     * @param finder 查询条件
     * @return
     */
    @GetMapping("findApply")
    public ViewResult findApply(ApplyFinder finder){
        return null;
    }

    /**
     * 处理申请信息
     * @param applyEntity  ,根据申请类型区分是借阅、延期、归还
     * @return
     */
    @PostMapping("/apply")
    public ViewResult apply(ApplyEntity applyEntity){
        return null;
    }

    /**
     * 管理审核申请信息
     * @param applyEntity 申请信息>,根据申请类型区分是借阅、延期、归还
     * @return
     */
    @PostMapping("/checkApply")
    public ViewResult checkApply(ApplyEntity applyEntity){
        return null;
    }

    /**
     * 领用处理
     * @param applyEntity
     * @return
     */
    @PostMapping("/getApply")
    public ViewResult getApply(ApplyEntity applyEntity){
        return null;
    }
}
