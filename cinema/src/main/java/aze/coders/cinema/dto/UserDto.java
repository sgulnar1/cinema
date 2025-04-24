package aze.coders.cinema.dto;

import aze.coders.cinema.entity.Authority;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Data
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;
    List<AuthorityDto> authorities;
}
