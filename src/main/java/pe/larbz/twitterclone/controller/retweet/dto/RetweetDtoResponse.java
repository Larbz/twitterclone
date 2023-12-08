package pe.larbz.twitterclone.controller.retweet.dto;

import lombok.Data;
import pe.larbz.twitterclone.controller.post.dto.PostDto;
import pe.larbz.twitterclone.controller.user.dto.UserDtoResponse;

@Data
public class RetweetDtoResponse {
    public PostDto postId;
    public UserDtoResponse userId;
}
