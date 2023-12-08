package pe.larbz.twitterclone.domain.follower;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import pe.larbz.twitterclone.domain.User;

import java.io.Serializable;

@Embeddable
public class FollowerId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "followerId")
    private User followerId;

    @ManyToOne
    @JoinColumn(name = "followingId")
    private User followingId;

}
