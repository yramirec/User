package com.business.user.builder;

import com.business.user.domain.PhoneDto;
import com.business.user.domain.UserDto;
import com.business.user.entity.Phone;
import com.business.user.entity.User;
import com.business.user.model.UserRequest;
import com.business.user.model.UserResponse;
import com.business.user.util.Utilitarios;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UserBuilder {


    public UserDto userRequestBuilder(UserRequest userRequest) {
        return UserDto.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .idUser(UUID.randomUUID().toString())
                .isactive(Boolean.TRUE.toString())
                .listPhones(listPhone(userRequest.getPhones()))
                .build();
    }

    public List<PhoneDto> listPhone(List<UserRequest.Phone> lista) {
        List<PhoneDto> list = new ArrayList<>();

        lista.forEach(x -> {
            list.add(PhoneDto.builder()
                    .idPhone(UUID.randomUUID().toString())
                    .cityCode(x.getCitycode())
                    .countryCode(x.getContrycode())
                    .number(x.getNumber())
                    .build());
        });
        return list;
    }

    public List<PhoneDto> listPhoneUserDto(List<Phone> lista) {
        List<PhoneDto> list = new ArrayList<>();

        lista.forEach(x -> {
            list.add(PhoneDto.builder()
                    .idPhone(UUID.randomUUID().toString())
                    .cityCode(x.getCityCode())
                    .countryCode(x.getCountryCode())
                    .number(x.getNumber())
                    .build());
        });
        return list;
    }


    public List<Phone> listPhoneUser(List<PhoneDto> lista) {
        List<Phone> list = new ArrayList<>();

        lista.forEach(x -> {
            list.add(Phone.builder()
                    .idPhone(UUID.randomUUID().toString())
                    .cityCode(x.getCityCode())
                    .countryCode(x.getCountryCode())
                    .number(x.getNumber())
                    .build());
        });
        return list;
    }

    public UserDto userBuilder(User user) {

        return UserDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .created(user.getCreated())
                .modified(user.getModified())
                .lastLogin(user.getLastLogin())
                .idUser(user.getIdUser())
                .isactive(user.getIsactive())
//                .listPhones(listPhoneUserDto(user.getListPhones()))
                .build();
    }


    public User userDto(UserDto userDto) {

        return User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .created(userDto.getCreated())
                .modified(userDto.getModified())
                .lastLogin(userDto.getLastLogin())
                .idUser(userDto.getIdUser())
                .isactive(userDto.getIsactive())
//                .listPhones(listPhoneUser(userDto.getListPhones()))
                .build();
    }

    public User userDtoSave(UserDto userDto) throws ParseException {

        return User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .created(Utilitarios.formateoFecha())
                .modified(Utilitarios.formateoFecha())
                .lastLogin(Utilitarios.formateoFecha())
                .idUser(userDto.getIdUser())
                .isactive(userDto.getIsactive())
//                .listPhones(listPhoneUser(userDto.getListPhones()))
                .build();
    }


    public UserResponse userResponseBuilder(UserDto userDto, String token) {

        return UserResponse.builder()
                .id(userDto.getIdUser())
                .created(userDto.getCreated())
                .last_login(userDto.getLastLogin())
                .isactive(userDto.getIsactive())
                .modified(userDto.getModified())
                .token(token)
                .build();
    }

    public Phone phoneBuilder(PhoneDto phoneDto, String idUser) {
        return Phone.builder()
                .idPhone(phoneDto.getIdPhone())
                .idUser(idUser)
                .countryCode(phoneDto.getCountryCode())
                .cityCode(phoneDto.getCityCode())
                .number(phoneDto.getNumber())
                .build();
    }
}
