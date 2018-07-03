package com.one.demo.service.impl;

import com.one.demo.dao.BooksDao;
import com.one.demo.entity.BooksEntity;
import com.one.demo.entity.UsersEntity;
import com.one.demo.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksDao booksDao;

    /**
     * 保存图书
     *
     * @param booksEntity
     */
    @Override
    public void saveBook(BooksEntity booksEntity) {
        booksDao.saveAndFlush(booksEntity);
    }

    /**
     * 获取所有图书
     *
     * @return
     */
    @Override
    public List<BooksEntity> findAllBooks() {
        return booksDao.findAll();
    }

    /**
     * 获取指定用户
     *
     * @return
     */
    @Override
    public List<BooksEntity> findUserBooks() {
        return null;
    }

    /**
     * 更新图书状态
     *
     * @param booksEntity
     */
    @Override
    public void updateBook(BooksEntity booksEntity) {

    }
}
