package pe.larbz.twitterclone.domain.follower;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity(name = "followers")
public class Follower {
    @EmbeddedId
    private FollowerId followerId;
}
