package com.business.user.service.Impl;

import com.business.user.builder.UserBuilder;
import com.business.user.dao.UserDao;
import com.business.user.domain.UserDto;
import com.business.user.model.UserRequest;
import com.business.user.model.UserResponse;
import com.business.user.repository.UserRepository;
import com.business.user.service.UserService;
import com.business.user.util.Constants;
import com.business.user.util.Response;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl  implements UserService {

    private final UserRepository userRepository;
    private final UserBuilder userBuilder;
    private final UserDao userDao;

    @Override
    public Response<UserResponse> registerUser(UserRequest userRequest) throws ParseException {

        Response<UserResponse> response = new Response<>();


        Boolean nameExists = userDao.findName(userRequest.getName());
        if (nameExists) {
            response.setHttpStatus(HttpStatus.CONFLICT);
            response.setMensaje(Constants.NAME_EXISTENTE);
            return response;
        }
        Boolean emailExists = userDao.findCorreo(userRequest.getEmail());
        if (emailExists) {
            response.setHttpStatus(HttpStatus.CONFLICT);
            response.setMensaje(Constants.EMAIL_EXISTENTE);
            return response;
        }
        UserDto user = userDao.registerUser(userBuilder.userRequestBuilder(userRequest));

        UserResponse userResponse = userBuilder.userResponseBuilder(user, getJWTToken(userRequest.getName()));
        response.setHttpStatus(HttpStatus.OK);
        response.setMensaje(Constants.SERVICE_SUCCESS);
        response.setResponseData(userResponse);

        return response;
    }

    private String getJWTToken(String username) {

        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        return Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();
    }
}
