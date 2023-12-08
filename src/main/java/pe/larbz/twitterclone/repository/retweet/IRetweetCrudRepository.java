package pe.larbz.twitterclone.repository.retweet;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.larbz.twitterclone.domain.retweet.Retweet;
import pe.larbz.twitterclone.domain.retweet.RetweetId;

public interface IRetweetCrudRepository extends JpaRepository<Retweet, RetweetId> {
}
