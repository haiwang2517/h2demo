/**
 * 书本表
  status = {0:库存中; 1:待领用; 3:已借出;}
 */
CREATE TABLE IF NOT EXISTS BOOKS (
  id NUMBER NOT NULL PRIMARY KEY ,
  name VARCHAR (100) NOT  NULL ,
  code VARCHAR (20) NULL ,
  bar_code VARCHAR (30) NULL ,
  author VARCHAR (50) NULL ,
  status NUMBER(2) not NULL  DEFAULT 0,
  create_date VARCHAR (25) NOT NULL ,
  last_version NUMBER NOT NULL DEFAULT 0,
  remark VARCHAR (400) NULL
);

/***
  * 申请图书流程主表, status = {0:申请中; 1:已结束;}
  */
CREATE TABLE IF NOT EXISTS  APPLY (
  id NUMBER PRIMARY KEY ,
  apply_code VARCHAR(30),
  create_date VARCHAR (25),
  apply_username VARCHAR (100),
  apply_reason VARCHAR (200),
  book_id NUMBER ,
  lazy_num NUMBER DEFAULT 0,
  status NUMBER
);

/**
 * use_date 领用日期; use_username:领用人; use_cycle: 使用周期
 * status :{0:待审核;1审核通过;2:审核退回}
 * type: {0:申请图书; 1:延期图书; 2;归还图书}
 * ref_task_id : 关联ID
 */
CREATE TABLE IF NOT EXISTS  APPLY_TASK (
  id NUMBER PRIMARY KEY ,
  apply_id NUMBER,
  apply_date VARCHAR (25),
  apply_username VARCHAR (100),
  apply_reason VARCHAR (200),
  use_date VARCHAR (25),
  use_username VARCHAR (100),
  use_cycle NUMBER ,
  check_username VARCHAR (100),
  ref_task_id NUMBER,
  type NUMBER,
  status NUMBER
);

/***
 *  用户自动学习表,更新最近登录时间
 */
CREATE TABLE IF NOT EXISTS  USERS(
  id NUMBER PRIMARY KEY ,
  name VARCHAR(100),
  code VARCHAR(100),
  num NUMBER ,
  type NUMBER ,
  last_date VARCHAR(25)
);

/**
 * 消息表
 */
CREATE TABLE IF NOT EXISTS  MESSAGES(
  id NUMBER PRIMARY KEY ,
  username VARCHAR(100),
  msg VARCHAR(100),
  create_date VARCHAR(25)
);