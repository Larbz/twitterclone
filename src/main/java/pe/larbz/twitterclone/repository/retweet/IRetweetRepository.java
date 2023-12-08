package pe.larbz.twitterclone.repository.retweet;

import pe.larbz.twitterclone.controller.retweet.dto.RetweetDtoResponse;
import pe.larbz.twitterclone.domain.retweet.Retweet;

import java.util.List;

public interface IRetweetRepository {

    List<RetweetDtoResponse> findAll();
}
