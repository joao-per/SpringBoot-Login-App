package com.empego.logintemplate.service;

import com.empego.logintemplate.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
