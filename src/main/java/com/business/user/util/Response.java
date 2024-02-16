package com.business.user.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<E> {

    private HttpStatus httpStatus;
    private String mensaje;
    private E responseData;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public E getResponseData() {
        return responseData;
    }

    public void setResponseData(E responseData) {
        this.responseData = responseData;
    }

    @Override
    public String toString() {
        return "Response{" +
                ", mensaje='" + mensaje +
                '}';
    }
}
