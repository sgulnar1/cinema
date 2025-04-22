package aze.coders.cinema;

import aze.coders.cinema.entity.Authority;
import aze.coders.cinema.entity.User;
import aze.coders.cinema.repository.AuthorityRepository;
import aze.coders.cinema.repository.UserRepository;
import ch.qos.logback.core.Appender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
//TODO
//auth sign out
//register - admin/user, role user - admin, crud user authorization
//request & response body is null

@SpringBootApplication
@RequiredArgsConstructor
public class CinemaApplication implements CommandLineRunner {
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Authority authorityUser = new Authority();
//        authorityUser.setAuthority("ROLE_USER");
//        authorityRepository.save(authorityUser);
//        Authority authorityAdmin = new Authority();
//        authorityAdmin.setAuthority("ROLE_ADMIN");
//        authorityRepository.save(authorityAdmin);
//        User user = new User();
//        user.setUsername("user");
//        user.setPassword(passwordEncoder.encode("1234"));
//        user.setAuthorities(List.of(authorityUser));
//        userRepository.save(user);
//        User userAdmin = new User();
//        userAdmin.setUsername("admin");
//        userAdmin.setPassword(passwordEncoder.encode("12345"));
//        userAdmin.setAuthorities(List.of(authorityUser, authorityAdmin));
//        userRepository.save(userAdmin);
    }
}
