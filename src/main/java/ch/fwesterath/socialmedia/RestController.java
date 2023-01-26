package ch.fwesterath.socialmedia;

import ch.fwesterath.socialmedia.model.Comment;
import ch.fwesterath.socialmedia.model.Post;
import ch.fwesterath.socialmedia.model.User;
import ch.fwesterath.socialmedia.model.Vote;
import ch.fwesterath.socialmedia.model.UserAdress;
import ch.fwesterath.socialmedia.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

/**
 * ViewController
 *    Inspiration: https://www.baeldung.com/hibernate-entitymanager
 * @author Peter Rutschmann
 * @version 12.12.2022
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRespository postRespository;

	@Autowired
	private VoteRepository voteRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private AdressRepository adressRepository;

	// API endpoints
	// Return all users
	@GetMapping("/users")
	public Iterable<User> userAll() {
		return userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public User userById(@PathVariable("id") Long id) {
		try {
			return userRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		}
	}

	@PostMapping("/users")
	public User userCreate(@RequestBody User user) {
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not created", e);
		}
	}

	@PutMapping("/users/{id}")
	public User userUpdate(@PathVariable("id") Long id, @RequestBody User user) {
		try {
			User userToUpdate = userRepository.findById(id).get();
			userToUpdate.setName(user.getName());
			return userRepository.save(userToUpdate);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not updated", e);
		}

	}

	@DeleteMapping("/users/{id}")
	public void userDelete(@PathVariable("id") Long id) {
		try {
			userRepository.deleteById(id);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not deleted", e);
		}
	}

	// Return all posts
	@GetMapping("/posts")
	public Iterable<Post> postAll() {
		try {
			return postRespository.findAll();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Posts not found", e);
		}
	}


	@GetMapping("/posts/{id}")
	public Post postById(@PathVariable("id") Long id) {
		try {
			return postRespository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
		}
}

	@PostMapping("/posts")
	public Post postCreate(@RequestBody Post post) {
		try {
			return postRespository.save(post);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Post not created", e);
		}
	}

	@PutMapping("/posts/{id}")
	public Post postUpdate(@PathVariable("id") Long id, @RequestBody Post post) {
		try {
			Post postToUpdate = postRespository.findById(id).get();
			postToUpdate.setCaption(post.getCaption());
			postToUpdate.setTopic(post.getTopic());
			postToUpdate.setUser(post.getUser());
			return postRespository.save(postToUpdate);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Post not updated", e);
		}
	}

	@DeleteMapping("/posts/{id}")
	public void postDelete(@PathVariable("id") Long id) {
		try {
			postRespository.deleteById(id);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Post not deleted", e);
		}
	}

	// Return all votes
	@GetMapping("/votes")
	public Iterable<Vote> voteAll() {
		try {
			return voteRepository.findAll();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Votes not found", e);
		}
	}

	@GetMapping("/votes/{id}")
	public Vote voteById(@PathVariable("id") Long id) {
		try {
			return voteRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vote not found");
		}
	}

	@PostMapping("/votes")
	public Vote voteCreate(@RequestBody Vote vote) {
		try {
			return voteRepository.save(vote);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vote not created", e);
		}
	}

	@PutMapping("/votes/{id}")
	public Vote voteUpdate() {
		try {
			Vote voteToUpdate = voteRepository.findById(1L).get();
			voteToUpdate.setPost(voteToUpdate.getPost());
			voteToUpdate.setUser(voteToUpdate.getUser());
			voteToUpdate.setTimestamp(voteToUpdate.getTimestamp());
			voteToUpdate.setUpvote(voteToUpdate.isUpvote());
			return voteRepository.save(voteToUpdate);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vote not found");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vote not updated", e);
		}
	}

	@DeleteMapping("/votes/{id}")
	public void voteDelete(@PathVariable("id") Long id) {
		try {
			voteRepository.deleteById(id);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vote not found");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vote not deleted", e);
		}
	}

	// Return all comments
	@GetMapping("/comments")
	public Iterable<Comment> commentAll() {
		try {
			return commentRepository.findAll();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comments not found", e);
		}
	}

	@GetMapping("/comments/{id}")
	public Comment commentById(@PathVariable("id") Long id) {
		try {
			return commentRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found");
		}
	}

	@PostMapping("/comments")
	public Comment commentCreate(@RequestBody Comment comment) {
		try {
			return commentRepository.save(comment);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comment not created", e);
		}
	}

	@PutMapping("/comments/{id}")
	public Comment commentUpdate(@PathVariable("id") Long id, @RequestBody Comment comment) {
		try {
			Comment commentToUpdate = commentRepository.findById(id).get();
			commentToUpdate.setPost(comment.getPost());
			commentToUpdate.setUser(comment.getUser());
			commentToUpdate.setDownvotes(comment.getDownvotes());
			commentToUpdate.setUpvotes(comment.getUpvotes());
			commentToUpdate.setText(comment.getText());
			return commentRepository.save(commentToUpdate);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comment not updated", e);
		}
	}

	@DeleteMapping("/comments/{id}")
	public void commentDelete(@PathVariable("id") Long id) {
		try {
			commentRepository.deleteById(id);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comment not deleted", e);
		}
	}

	@GetMapping("/adress")
	public Iterable<UserAdress> adressAll() {
		try {
			return adressRepository.findAll();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Adresses not found", e);
		}
	}

	@GetMapping("/adress/{id}")
	public UserAdress adressById(@PathVariable("id") Long id) {
		try {
			return adressRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Adress not found");
		}
	}

	@PostMapping("/adress")
	public UserAdress adressCreate(@RequestBody UserAdress adress) {
		try {
			return adressRepository.save(adress);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Adress not created", e);
		}
	}

	@PutMapping("/adress/{id}")
	public UserAdress adressUpdate(@PathVariable("id") Long id, @RequestBody UserAdress adress) {
		try {
			UserAdress adressToUpdate = adressRepository.findById(id).get();
			adressToUpdate.setCity(adress.getCity());
			adressToUpdate.setCountry(adress.getCountry());
			adressToUpdate.setStreet(adress.getStreet());
			adressToUpdate.setZip(adress.getZip());
			adressToUpdate.setUser(adress.getUser());
			return adressRepository.save(adressToUpdate);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Adress not found");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Adress not updated", e);
		}
	}

	@DeleteMapping("/adress/{id}")
	public void adressDelete(@PathVariable("id") Long id) {
		try {
			adressRepository.deleteById(id);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Adress not found");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Adress not deleted", e);
		}
	}


}