package pe.larbz.twitterclone.repository.user;


import pe.larbz.twitterclone.controller.user.dto.UserDtoResponse;
import pe.larbz.twitterclone.domain.User;

import java.util.List;

public interface IUserRepository{
    List<UserDtoResponse> findAllByOrderByFirstNameAsc();
    User save(User user);

}
