package pe.larbz.twitterclone.repository.retweet;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import pe.larbz.twitterclone.controller.retweet.dto.RetweetDtoResponse;
import pe.larbz.twitterclone.domain.retweet.Retweet;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Repository
public class RetweetRepositoryImpl implements IRetweetRepository{

    private final IRetweetCrudRepository _retweetRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<RetweetDtoResponse> findAll() {
        return _retweetRepository.findAll().stream().map(retweet -> modelMapper.map(retweet, RetweetDtoResponse.class)).collect(Collectors.toList());
    }
}
