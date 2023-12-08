package pe.larbz.twitterclone.controller.user.dto;

import lombok.Data;

@Data
public class UserDtoResponse {
    private Long userId;
    private String firstName;
    private String lastName;
}
