package pe.larbz.twitterclone.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.larbz.twitterclone.controller.user.dto.UserDtoResponse;
import pe.larbz.twitterclone.domain.User;

import java.util.List;

public interface IUserCrudRepository extends JpaRepository<User,Long> {
    List<User> findAllByOrderByFirstNameAsc();
}
