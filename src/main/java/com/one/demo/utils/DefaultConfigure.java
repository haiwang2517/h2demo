package com.one.demo.utils;

public class DefaultConfigure {
//0:申请中;1:待领取;2:已领取;3:取消申请;
//4:申请延期;5:已延期;6: 取消延期申请;
//7:申请归还;8:已归还;9:取消归还申请


    public static final int APPLY_STATUS_BORROW_APPLY = 0;
    public static final int APPLY_STATUS_BORROW_STAY_PULL = 1;
    public static final int APPLY_STATUS_BORROW_FINISH_PULL = 2;
    public static final int APPLY_STATUS_BORROW_CANCEL_APPLY = 3;
    public static final int APPLY_STATUS_LAZY_APPLY = 4;
    public static final int APPLY_STATUS_LAZY_FINISH = 5;
    public static final int APPLY_STATUS_LAZY_CANCEL = 6;
    public static final int APPLY_STATUS_BACK_APPLY = 7;
    public static final int APPLY_STATUS_BACK_FINISH = 8;
    public static final int APPLY_STATUS_BACK_CANCEL = 9;

    public static final int  APPLY_CYCLE = 2;  //2天


//    * status :{0:待审核;1审核通过;2:审核退回;3:已取消}
    public static final int TASK_STATUS_CHECK = 0;
    public static final int TASK_STATUS_SUCCESS = 1;
    public static final int TASK_STATUS_BACK = 2;
    public static final int TASK_STATUS_CANCEL = 3;

// * type: {0:申请图书; 1:延期图书; 2;归还图书}
    public static final int TASK_TYPE_APPLY = 0;
    public static final int TASK_TYPE_LAZY = 1;
    public static final int TASK_TYPE_BACK = 2;



}
