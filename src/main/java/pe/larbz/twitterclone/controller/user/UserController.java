package pe.larbz.twitterclone.controller.user;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.larbz.twitterclone.controller.user.dto.UserDtoResponse;
import pe.larbz.twitterclone.domain.User;
import pe.larbz.twitterclone.repository.user.UserRepositoryImpl;

import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private final UserRepositoryImpl _userRepository;

    @GetMapping
    public List<UserDtoResponse> findAll(){
        return _userRepository.findAllByOrderByFirstNameAsc();
    }

    @PostMapping
    public User create(@RequestBody @Validated User user){
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setUserEmail(user.getUserEmail());
        newUser.setUserPassword(user.getUserPassword());
        newUser.setGender(user.getGender());

        _userRepository.save(newUser);

        return newUser;
    }
}
