package pe.larbz.twitterclone.repository.post;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import pe.larbz.twitterclone.controller.post.dto.PostDto;
import pe.larbz.twitterclone.controller.post.dto.PostDtoResponse;
import pe.larbz.twitterclone.domain.Post;
import pe.larbz.twitterclone.domain.User;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class PostRepositoryImpl implements IPostRepository{

    private final IPostCrudRepository _postRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<PostDtoResponse> findAll() {
        return _postRepository.findAll().stream().map(post->modelMapper.map(post,PostDtoResponse.class)).collect(Collectors.toList());
    }

    @Override
    public PostDtoResponse create(Post post) {
//        Post savedPost = _postRepository.save(post); // save entity
//        return modelMapper.map(savedPost,PostDtoResponse.class);
        return modelMapper.map(_postRepository.save(post), PostDtoResponse.class);
    }

    @Override
    public void delete(Long id) {
        _postRepository.deleteById(id);
    }
}
