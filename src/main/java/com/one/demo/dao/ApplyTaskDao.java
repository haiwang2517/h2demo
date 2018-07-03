package com.one.demo.dao;

import com.one.demo.entity.ApplyTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyTaskDao extends JpaRepository<ApplyTaskEntity, Long> {
}
