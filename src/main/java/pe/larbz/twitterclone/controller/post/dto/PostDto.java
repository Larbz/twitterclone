package pe.larbz.twitterclone.controller.post.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import pe.larbz.twitterclone.domain.User;

import java.time.LocalDateTime;

@Data
public class PostDto {
    @NotBlank
    private String postContent;

    @NotNull
    private Long userId;
}
