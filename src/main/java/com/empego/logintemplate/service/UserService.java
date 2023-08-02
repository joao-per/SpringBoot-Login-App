package com.empego.logintemplate.service;

import java.util.List;

import com.empego.logintemplate.dto.UserDto;
import com.empego.logintemplate.entity.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
