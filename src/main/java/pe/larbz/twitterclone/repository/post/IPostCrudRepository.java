package pe.larbz.twitterclone.repository.post;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.larbz.twitterclone.domain.Post;

public interface IPostCrudRepository extends JpaRepository<Post,Long> {
//    @Override
//    save(S entity);
}
