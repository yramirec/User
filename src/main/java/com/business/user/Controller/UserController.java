package com.business.user.Controller;

import com.business.user.model.UserRequest;
import com.business.user.model.UserResponse;
import com.business.user.service.UserService;
import com.business.user.util.Constants;
import com.business.user.util.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class UserController extends ValidationHandler{

    private final UserService userService;


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/user/register",
            method = RequestMethod.PUT, produces = "application/json; charset=UTF-8")
    public ResponseEntity<Response<UserResponse>> createUser(@RequestBody @Valid UserRequest request,
                                                   HttpServletRequest httpResquest) {

        Response<UserResponse> response = new Response<>();
        try {
            response = userService.registerUser(request);
        } catch (Exception e) {

            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMensaje("Error createUser Controller.");
        }

        return new ResponseEntity<Response<UserResponse>>(response, response.getHttpStatus());
    }

}
