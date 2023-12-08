package pe.larbz.twitterclone.domain.retweet;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import pe.larbz.twitterclone.domain.Post;
import pe.larbz.twitterclone.domain.User;

@Entity
@Getter
public class Retweet {

    @EmbeddedId
    @JsonBackReference
    private RetweetId retweetId;

//    @MapsId("postId")
    @ManyToOne
    @JoinColumn(name = "postId",insertable = false, updatable = false)
    private Post postId;

//    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "userId",insertable = false, updatable = false)
    private User userId;
}
