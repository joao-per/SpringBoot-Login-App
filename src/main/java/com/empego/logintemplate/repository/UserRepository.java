package com.empego.logintemplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empego.logintemplate.entity.User;

// The code is defining a repository interface called `UserRepository` that extends the `JpaRepository`
// interface.
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
