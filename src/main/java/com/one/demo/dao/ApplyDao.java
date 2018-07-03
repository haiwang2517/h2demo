package com.one.demo.dao;

import com.one.demo.entity.ApplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyDao extends JpaRepository<ApplyEntity, Long> {

}
