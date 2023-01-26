package ch.fwesterath.socialmedia.repository;

import ch.fwesterath.socialmedia.model.UserAdress;
import org.springframework.data.repository.CrudRepository;

public interface AdressRepository extends CrudRepository<UserAdress, Long> {

}

