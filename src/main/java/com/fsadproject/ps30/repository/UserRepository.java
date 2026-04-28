package com.fsadproject.ps30.repository;

import com.fsadproject.ps30.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // 🔥 find user by email
    User findByEmail(String email);
}