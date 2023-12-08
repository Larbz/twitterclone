package pe.larbz.twitterclone.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import pe.larbz.twitterclone.domain.retweet.Retweet;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long userId;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String userEmail;

    @NotBlank
    private String userPassword;

    @NotBlank
    private String gender;

    @JsonBackReference
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Post> posts;
//
//    @OneToMany(mappedBy = "userId",fetch = FetchType.LAZY)
//    private List<Like> likes;
//

    @JsonBackReference
    @OneToMany(mappedBy = "retweetId.userId",fetch = FetchType.LAZY)
    private List<Retweet> retweets;

}
