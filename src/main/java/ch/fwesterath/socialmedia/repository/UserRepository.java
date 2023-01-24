package ch.fwesterath.socialmedia.repository;

import ch.fwesterath.socialmedia.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
