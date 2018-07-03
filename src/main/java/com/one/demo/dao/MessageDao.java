package com.one.demo.dao;

import com.one.demo.entity.MessagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDao extends JpaRepository<MessagesEntity, Long> {
}
