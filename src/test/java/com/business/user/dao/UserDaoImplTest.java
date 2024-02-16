package com.business.user.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.business.user.builder.UserBuilder;
import com.business.user.dao.Impl.UserDaoImpl;
import com.business.user.domain.UserDto;
import com.business.user.entity.Phone;
import com.business.user.entity.User;
import com.business.user.repository.PhoneRepository;
import com.business.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PhoneRepository phoneRepository;

    @Mock
    private UserBuilder userBuilder;

    @InjectMocks
    private UserDaoImpl userDaoImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userRepository = mock(UserRepository.class);
        phoneRepository = mock(PhoneRepository.class);
        userBuilder = mock(UserBuilder.class);

        userDaoImpl = new UserDaoImpl(userRepository, phoneRepository, userBuilder);

    }

    @Test
    public void testRegisterUser() throws ParseException {
        //testestRegisterUser
    }

    @Test
    public void testFindCorreo() {
        // Configuración de datos de prueba
        String emailRequest = "test@example.com";
        when(userRepository.findByEmail(emailRequest)).thenReturn("test@example.com");

        // Ejecuta el método a probar
        Boolean result = userDaoImpl.findCorreo(emailRequest);

        // Verifica que el resultado sea verdadero
        assertTrue(result);
    }

    @Test
    public void testFindName() {
        // Configuración de datos de prueba
        String name = "testUser";
        when(userRepository.findByUser(name)).thenReturn(new User());

        // Ejecuta el método a probar
        Boolean result = userDaoImpl.findName(name);

        // Verifica que el resultado sea verdadero
        assertTrue(result);
    }
}
