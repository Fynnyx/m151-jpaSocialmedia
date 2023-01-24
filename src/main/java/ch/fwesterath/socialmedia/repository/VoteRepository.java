package ch.fwesterath.socialmedia.repository;

import org.springframework.data.repository.CrudRepository;
import ch.fwesterath.socialmedia.model.Vote;

public interface VoteRepository extends CrudRepository<Vote, Long> {

}
