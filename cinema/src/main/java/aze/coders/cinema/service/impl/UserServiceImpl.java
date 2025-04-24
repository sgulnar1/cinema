package aze.coders.cinema.service.impl;

import aze.coders.cinema.repository.UserRepository;
import aze.coders.cinema.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import aze.coders.cinema.config.EnhancedObjectMapper;
import aze.coders.cinema.dto.UserDto;
import aze.coders.cinema.entity.User;
import aze.coders.cinema.enums.ErrorCode;
import aze.coders.cinema.exception.NotFoundException;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final EnhancedObjectMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getUsers() {
        return Arrays.asList(mapper.convertValue(userRepository.findAll(), UserDto[].class));
    }

    @Override
    public UserDto getUserById(Integer id) {
        return mapper.convertValue(findById(id), UserDto.class);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapper.convertValue(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return mapper.convertValue(userRepository.save(user), UserDto.class);
    }

    @Override
    public void deleteUser(Integer id) {
        findById(id);
        userRepository.deleteById(id);
    }

    @Override
    public UserDto updateUser(Integer id, UserDto userDto) {
        User findUser = findById(id);
        User user = mapper.convertValue(userDto, User.class);
        user.setId(findUser.getId());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return mapper.convertValue(userRepository.save(user), UserDto.class);
    }

    private User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
