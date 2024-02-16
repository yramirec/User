package com.business.user.controller;

import com.business.user.Controller.UserController;
import com.business.user.model.UserRequest;
import com.business.user.model.UserResponse;
import com.business.user.service.UserService;
import com.business.user.util.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.ParseException;

import static org.mockito.Mockito.*;

public class UserControllerTest {
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userController = new UserController(userService);
    }

    @Test
    public void testCreateUser() throws ParseException {
        // Crear una solicitud de usuario de ejemplo
        UserRequest request = new UserRequest();

        // Crear una respuesta simulada del servicio
        Response<UserResponse> response = new Response<>();
        response.setHttpStatus(HttpStatus.OK);
        // Aquí puedes configurar el contenido de la respuesta según tus necesidades
        // response.setData(...);

        // Configura el comportamiento simulado del servicio
        when(userService.registerUser(request)).thenReturn(response);

        // Simula una solicitud HTTP (puedes usar una biblioteca de simulación como MockMvc en lugar de HttpServletRequest real)
        HttpServletRequest httpRequest = mock(HttpServletRequest.class);

        // Llama al método createUser de UserController
        ResponseEntity<Response<UserResponse>> responseEntity = userController.createUser(request, httpRequest);

        // Verifica que se llame al método registerUser del servicio
        verify(userService, times(1)).registerUser(request);

        // Verifica que el código de estado de la respuesta sea el esperado
        assert(responseEntity.getStatusCode()).equals(HttpStatus.OK); // Puedes ajustar el código de estado según tus requisitos

        // Verifica otros aspectos de la respuesta si es necesario
        // assert(responseEntity.getBody().getData()...);
    }
}
