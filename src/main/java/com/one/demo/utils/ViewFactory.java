package com.one.demo.utils;

import com.one.demo.controller.dto.ViewResult;

public class ViewFactory {
    public static ViewResult getSuccess(Object list) {
        return new ViewResult(200, "操作成功", list);
    }

    public static ViewResult getSuccess() {
        return ViewFactory.getSuccess(null);
    }


    public static ViewResult getFault(String msg) {
        return new ViewResult(300, msg);
    }

    public static ViewResult getFault() {
        return ViewFactory.getFault("操作失败");
    }

}
