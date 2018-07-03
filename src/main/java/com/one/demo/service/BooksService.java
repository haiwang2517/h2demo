package com.one.demo.service;

import com.one.demo.entity.BooksEntity;
import com.one.demo.entity.UsersEntity;

import java.util.List;

public interface BooksService {

    /**
     * 保存图书
     * @param usersEntity
     */
    void saveBook(BooksEntity booksEntity);

    /**
     * 获取所有图书
     * @return
     */
    List<BooksEntity> findAllBooks();

    /**
     * 获取指定用户
     * @return
     */
    List<BooksEntity> findUserBooks();

    /**
     * 更新图书状态
     * @param usersEntity
     */
    void updateBook(BooksEntity booksEntity);

}
