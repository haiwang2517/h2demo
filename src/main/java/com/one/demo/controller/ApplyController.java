package com.one.demo.controller;

import com.one.demo.controller.dto.ViewResult;
import com.one.demo.entity.ApplyEntity;
import com.one.demo.service.ApplyService;
import com.one.demo.service.finder.ApplyFinder;
import com.one.demo.utils.ViewFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    @GetMapping("/getApplys")
    public ViewResult applyList(ApplyFinder finder){
        try {
            List<ApplyEntity> applyEntities =   applyService.findAll(finder);
            return ViewFactory.getSuccess(applyEntities);
        } catch (Exception e) {
            return ViewFactory.getFault(e.getMessage());
        }
    }
}
