package com.srg.user.repository;

import com.srg.user.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(String userId);

    User findByUserNo(long userNo);
}
