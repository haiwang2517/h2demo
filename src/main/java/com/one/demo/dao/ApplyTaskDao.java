package com.one.demo.dao;

import com.one.demo.entity.ApplyTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyTaskDao extends JpaRepository<ApplyTaskEntity, Long> {

    List<ApplyTaskEntity> findByApplyId(Long applyId);
}
