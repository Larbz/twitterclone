package pe.larbz.twitterclone.domain.like;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import pe.larbz.twitterclone.domain.Post;
import pe.larbz.twitterclone.domain.User;

@Entity(name = "likes")
@Data
public class Like {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long likeId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userId",insertable = false,updatable = false)
//    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId",insertable = false,updatable = false)
    private Post postId;

    @EmbeddedId
    private LikeId likeId;
}
