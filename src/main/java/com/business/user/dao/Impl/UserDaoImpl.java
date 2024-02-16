package com.business.user.dao.Impl;

import com.business.user.builder.UserBuilder;
import com.business.user.dao.UserDao;
import com.business.user.domain.UserDto;
import com.business.user.entity.User;
import com.business.user.repository.PhoneRepository;
import com.business.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Objects;

@Component
@AllArgsConstructor
public class UserDaoImpl  implements UserDao {

    private final UserRepository userRepository;
    private final PhoneRepository phoneRepository;
    private final UserBuilder userBuilder;

    @Override
    public UserDto registerUser(UserDto userDto) throws ParseException {
        User userRequest = userBuilder.userDtoSave(userDto);
        userRepository.save(userRequest);
        userDto.getListPhones().forEach(x -> {
            phoneRepository.save(userBuilder.phoneBuilder(x, userRequest.getIdUser()));
        });
        User user = userRepository.findById(userDto.getIdUser()).get();
        return userBuilder.userBuilder(user);
    }

    @Override
    public Boolean findCorreo(String emailRequest) {
        String email = userRepository.findByEmail(emailRequest);
        return !Objects.isNull(email) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public Boolean findName(String name) {

        User user = userRepository.findByUser(name);
        return !Objects.isNull(user) ? Boolean.TRUE : Boolean.FALSE;
    }


}
