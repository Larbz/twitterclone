package pe.larbz.twitterclone.controller.retweet;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.larbz.twitterclone.controller.retweet.dto.RetweetDtoResponse;
import pe.larbz.twitterclone.domain.retweet.Retweet;
import pe.larbz.twitterclone.repository.retweet.RetweetRepositoryImpl;

import java.util.List;

@RestController
@RequestMapping("api/retweets")
@AllArgsConstructor
public class RetweetController {

    private final RetweetRepositoryImpl _retweetRepository;

    @GetMapping
    public List<RetweetDtoResponse> findAll(){
        return _retweetRepository.findAll();
    }
}
