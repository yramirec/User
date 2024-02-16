package com.business.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {

    @NotNull(message = "El name no puede ser nulo")
    @NotEmpty(message = "El name no puede ser vacio")
    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",
            message = "Formato invalido de correo. "
                    + "Debe tener el siguiente formato aaaaaaa@dominio.cl")
    @NotNull(message = "El email no puede ser nulo")
    @NotEmpty(message = "El email no puede ser vacio")
    private String email;

    @Pattern(regexp = "([A-Z][a-z]+[0-9][0-9])$",
            message = "Formato invalido de password. "
                    + "Debe contener una mayúscula, minúsculas y dos números")

    @NotNull(message = "El password no puede ser nulo")
    @NotEmpty(message = "El password no puede ser vacio")
    private String password;
    @NotNull
    @NotEmpty
    private List<Phone> phones;

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Phone {
        @NotNull(message = "El number no puede ser nulo")
        @NotEmpty(message = "El number no puede ser vacio")
        private String number;

        @NotNull(message = "El citycode no puede ser nulo")
        @NotEmpty(message = "El citycode no puede ser vacio")
        private String citycode;

        @NotNull(message = "El contrycode no puede ser nulo")
        @NotEmpty(message = "El contrycode no puede ser vacio")
        private String contrycode;
    }
}
