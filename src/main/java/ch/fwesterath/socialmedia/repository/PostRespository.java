package ch.fwesterath.socialmedia.repository;

import ch.fwesterath.socialmedia.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRespository extends CrudRepository<Post, Long> {

}
