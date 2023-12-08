package pe.larbz.twitterclone.repository.user;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import pe.larbz.twitterclone.controller.user.dto.UserDtoResponse;
import pe.larbz.twitterclone.domain.User;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements IUserRepository {

    private final IUserCrudRepository _userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserDtoResponse> findAllByOrderByFirstNameAsc(){
        return _userRepository.findAllByOrderByFirstNameAsc().stream().map(user -> modelMapper.map(user,UserDtoResponse.class)).collect(Collectors.toList());
    }

    @Override
    public User save(User user){
        return _userRepository.save(user);
    }
}
