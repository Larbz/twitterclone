package pe.larbz.twitterclone.controller.post.dto;

import lombok.Data;
import pe.larbz.twitterclone.controller.user.dto.UserDtoResponse;
import pe.larbz.twitterclone.domain.User;

import java.time.LocalDateTime;

@Data
public class PostDtoResponse {

    private Long postId;

    private String postContent;

    private LocalDateTime timeCreated;

    private Integer retweetsCount;

    private Integer likesCount;

    private UserDtoResponse user;

}
