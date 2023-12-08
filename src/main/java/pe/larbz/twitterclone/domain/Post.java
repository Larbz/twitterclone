package pe.larbz.twitterclone.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Check;
import pe.larbz.twitterclone.domain.like.Like;
import pe.larbz.twitterclone.domain.retweet.Retweet;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Check(constraints = "retweetsCount >= 0")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long postId;

    @NotBlank
    private String postContent;

    @NotNull
    private LocalDateTime timeCreated;

//    @ToString.Exclude
//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id",updatable = false)
    private User user;

    @NotNull
    @Min(0)
    private Integer retweetsCount = 0;

    @Min(0)
    @NotNull
    private Integer likesCount = 0;


    @JsonBackReference
    @OneToMany(mappedBy = "postId",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Like> likes;

    @JsonBackReference
    @OneToMany(mappedBy = "postId",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Retweet> retweets;

    @PrePersist
    public void createDate(){
        this.timeCreated = LocalDateTime.now();
    }

}
