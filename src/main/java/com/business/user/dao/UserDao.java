package com.business.user.dao;

import com.business.user.domain.UserDto;

import java.text.ParseException;

public interface UserDao {

    UserDto registerUser(UserDto userDto) throws ParseException;
    Boolean findCorreo(String emailRequest);
    Boolean findName(String name);
}
