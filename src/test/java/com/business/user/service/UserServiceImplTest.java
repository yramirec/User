package com.business.user.service;

import com.business.user.builder.UserBuilder;
import com.business.user.dao.UserDao;
import com.business.user.domain.UserDto;
import com.business.user.model.UserRequest;
import com.business.user.model.UserResponse;
import com.business.user.repository.UserRepository;
import com.business.user.service.Impl.UserServiceImpl;
import com.business.user.util.Constants;
import com.business.user.util.Response;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private UserBuilder userBuilder;

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser_Success() throws ParseException {
        // Configuración de datos de prueba
        UserRequest userRequest = new UserRequest();
        userRequest.setName("testuser");
        userRequest.setEmail("test@example.com");

        UserDto userDto = new UserDto(); // Supongamos que tienes un objeto UserDto configurado aquí

        when(userDao.findName("testuser")).thenReturn(false);
        when(userDao.findCorreo("test@example.com")).thenReturn(false);
        when(userDao.registerUser(any(UserDto.class))).thenReturn(userDto);

        // Simulación de JWT
        when(userBuilder.userResponseBuilder(any(UserDto.class), any(String.class))).thenReturn(new UserResponse());

        // Llamada al método que quieres probar
        Response<UserResponse> response = userService.registerUser(userRequest);

        // Verificación de resultados
        assertEquals(HttpStatus.OK, response.getHttpStatus());
        assertEquals(Constants.SERVICE_SUCCESS, response.getMensaje());
        // Puedes agregar más aserciones para verificar otros detalles del resultado si es necesario
    }

    @Test
    void testRegisterUser_NameAlreadyExists() throws ParseException {
        // Configuración de datos de prueba
        UserRequest userRequest = new UserRequest();
        userRequest.setName("testuser");
        userRequest.setEmail("test@example.com");

        when(userDao.findName("testuser")).thenReturn(true); // Nombre ya existe

        // Llamada al método que quieres probar
        Response<UserResponse> response = userService.registerUser(userRequest);

        // Verificación de resultados
        assertEquals(HttpStatus.CONFLICT, response.getHttpStatus());
        assertEquals(Constants.NAME_EXISTENTE, response.getMensaje());
        // Asegúrate de que otras propiedades de la respuesta sean las esperadas
    }

    @Test
    void testRegisterUser_EmailAlreadyExists() throws ParseException {
        // Configuración de datos de prueba
        UserRequest userRequest = new UserRequest();
        userRequest.setName("testuser");
        userRequest.setEmail("test@example.com");

        when(userDao.findName("testuser")).thenReturn(false);
        when(userDao.findCorreo("test@example.com")).thenReturn(true); // Correo electrónico ya existe

        // Llamada al método que quieres probar
        Response<UserResponse> response = userService.registerUser(userRequest);

        // Verificación de resultados
        assertEquals(HttpStatus.CONFLICT, response.getHttpStatus());
        assertEquals(Constants.EMAIL_EXISTENTE, response.getMensaje());
        // Asegúrate de que otras propiedades de la respuesta sean las esperadas
    }

}
