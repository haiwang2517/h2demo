package com.one.demo.dao;

import com.one.demo.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends JpaRepository<UsersEntity,Long> {
}
