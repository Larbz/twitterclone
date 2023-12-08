package pe.larbz.twitterclone.repository.post;

import pe.larbz.twitterclone.controller.post.dto.PostDto;
import pe.larbz.twitterclone.controller.post.dto.PostDtoResponse;
import pe.larbz.twitterclone.domain.Post;

import java.util.List;

public interface IPostRepository {

    List<PostDtoResponse> findAll();
    PostDtoResponse create(Post post);
    void delete(Long id);
}
