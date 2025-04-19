package aze.coders.cinema.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RefreshTokenDto {
    private Integer id;
    private String token;
    private String username;
    private Boolean valid;
    private Date issueDate;
    private Date expiryDate;

}
