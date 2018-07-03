package com.one.demo.dao;

import com.one.demo.entity.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksDao extends JpaRepository<BooksEntity, Long> {

}
