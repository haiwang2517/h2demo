package com.one.demo.controller.dto;

import java.io.Serializable;

public class ViewResult  implements Serializable{
        private Integer code ;
        private String msg;
        private Object list;

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setList(Object list) {
        this.list = list;
    }

    public ViewResult(Integer code, String msg, Object list) {
        this.code = code;
        this.msg = msg;
        this.list = list;
    }

    public ViewResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
