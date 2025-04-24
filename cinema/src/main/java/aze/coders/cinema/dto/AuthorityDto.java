package aze.coders.cinema.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class AuthorityDto implements GrantedAuthority {
    private Integer id;
    private String authority;
}
