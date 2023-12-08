package pe.larbz.twitterclone.domain.like;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.larbz.twitterclone.domain.Post;
import pe.larbz.twitterclone.domain.User;

import java.io.Serializable;

@Embeddable
public class LikeId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "postId")
    private Post postId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;
}
