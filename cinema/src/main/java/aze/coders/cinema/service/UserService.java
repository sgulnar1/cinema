package aze.coders.cinema.service;

import aze.coders.cinema.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserDto> getUsers();

    UserDto getUserById(Integer id);

    UserDto createUser(UserDto userDto);

    void deleteUser(Integer id);

    UserDto updateUser(Integer id, UserDto userDto);
}

