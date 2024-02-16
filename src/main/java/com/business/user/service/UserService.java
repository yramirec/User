package com.business.user.service;

import com.business.user.model.UserRequest;
import com.business.user.model.UserResponse;
import com.business.user.util.Response;

import java.text.ParseException;

public interface UserService {

    Response<UserResponse> registerUser(UserRequest userRequest) throws ParseException;
}
