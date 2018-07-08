package com.one.demo.controller;

import com.one.demo.service.BooksService;
import com.one.demo.controller.dto.ViewResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

    private Logger logger = LoggerFactory.getLogger(BooksController.class);

    @Autowired
    private BooksService booksService;

    /**
     * 获取图书列表
     * @return
     */
    @RequestMapping(value = "/findBooks",method = RequestMethod.GET)
    public ViewResult findBooks(){

        return null;
    }

}
