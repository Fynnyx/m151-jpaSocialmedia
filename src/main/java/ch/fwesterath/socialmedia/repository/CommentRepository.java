package ch.fwesterath.socialmedia.repository;

import ch.fwesterath.socialmedia.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
