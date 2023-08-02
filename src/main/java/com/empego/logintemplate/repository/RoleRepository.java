package com.empego.logintemplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empego.logintemplate.entity.Role;

// The code is defining a repository interface called `RoleRepository` that extends the `JpaRepository`
// interface.
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
