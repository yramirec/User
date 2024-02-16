package com.business.user.controller;

import com.business.user.Controller.ValidationHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationHandlerTest {
    private ValidationHandler validationHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        validationHandler = new ValidationHandler();
    }

    @Test
    public void testHandleMethodArgumentNotValid() {
        // Puedes agregar más aserciones para verificar los detalles específicos de los errores si es necesario
    }

}
