package pe.larbz.twitterclone.controller.post;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pe.larbz.twitterclone.controller.post.dto.PostDto;
import pe.larbz.twitterclone.controller.post.dto.PostDtoResponse;
import pe.larbz.twitterclone.domain.Post;
import pe.larbz.twitterclone.domain.User;
import pe.larbz.twitterclone.repository.post.IPostCrudRepository;
import pe.larbz.twitterclone.repository.post.PostRepositoryImpl;
import pe.larbz.twitterclone.repository.user.IUserCrudRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/posts")
@AllArgsConstructor
public class PostController {

    private final PostRepositoryImpl _postRepository;
    private final IUserCrudRepository _userRepository;

    @GetMapping
    public List<PostDtoResponse> findAll(){
        return _postRepository.findAll();
    }

    @PostMapping
    public PostDtoResponse create(@RequestBody @Validated PostDto postDto){
//        System.out.println(post.getUserId().getId());
//        Post newPost = new Post();

//        Post newPost = new ModelMapper().map(postDto,Post.class);

        Optional<User> user = _userRepository.findById(postDto.getUserId());
//        newPost.setPostContent(postDto.getPostContent());

//        System.out.println(user.get());

        if(!user.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User doesnt exist");
            //            System.out.println("We entered here");

//            newPost.setUserId(user.get());
        }
        Post newPost = new ModelMapper().map(postDto,Post.class);
//        Post newPost = new Post();
//        newPost.setPostContent(postDto.getPostContent());
        newPost.setUser(user.get());
//        System.out.println(newPost);
//        newPost.createDate();
//        System.out.println(newPost.getUserId());
        _postRepository.create(newPost);

        PostDtoResponse responsePost = new ModelMapper().map(newPost,PostDtoResponse.class);
        return responsePost;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
//        Optional<Post> postToDelete = _postRepository.findById(id);
//        _postRepository.delete(postToDelete.get());
        _postRepository.delete(id);
    }
}
