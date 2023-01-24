package ch.fwesterath.socialmedia;

import ch.fwesterath.socialmedia.model.Comment;
import ch.fwesterath.socialmedia.model.Post;
import ch.fwesterath.socialmedia.model.User;
import ch.fwesterath.socialmedia.model.Vote;
import ch.fwesterath.socialmedia.repository.CommentRepository;
import ch.fwesterath.socialmedia.repository.PostRespository;
import ch.fwesterath.socialmedia.repository.UserRepository;
import ch.fwesterath.socialmedia.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	// API endpoints
	// Return all users
	@GetMapping("/users")
	public Iterable<User> userAll() {
		return userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public User userById(@PathVariable("id") Long id) {
		return userRepository.findById(id).get();
	}

	@PostMapping("/users")
	public User userCreate(@RequestBody User user) {
		return userRepository.save(user);
	}

	@PutMapping("/users/{id}")
	public User userUpdate(@PathVariable("id") Long id, @RequestBody User user) {
		User userToUpdate = userRepository.findById(id).get();
		userToUpdate.setName(user.getName());
		return userRepository.save(userToUpdate);
	}

	@DeleteMapping("/users/{id}")
	public void userDelete(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
	}

	// Return all posts
	@GetMapping("/posts")
	public Iterable<Post> postAll() {
		return postRespository.findAll();
	}

	@GetMapping("/posts/{id}")
	public Post postById(@PathVariable("id") Long id) {
		return postRespository.findById(id).get();
	}

	@PostMapping("/posts")
	public Post postCreate(@RequestBody Post post) {
		return postRespository.save(post);
	}

	@PutMapping("/posts/{id}")
	public Post postUpdate(@PathVariable("id") Long id, @RequestBody Post post) {
		Post postToUpdate = postRespository.findById(id).get();
		postToUpdate.setCaption(post.getCaption());
		postToUpdate.setTopic(post.getTopic());
		postToUpdate.setUser(post.getUser());
		return postRespository.save(postToUpdate);
	}

	@DeleteMapping("/posts/{id}")
	public void postDelete(@PathVariable("id") Long id) {
		postRespository.deleteById(id);
	}

	// Return all votes
	@GetMapping("/votes")
	public Iterable<Vote> voteAll() {
		return voteRepository.findAll();
	}

	@GetMapping("/votes/{id}")
	public Vote voteById(@PathVariable("id") Long id) {
		return voteRepository.findById(id).get();
	}

	@PostMapping("/votes")
	public Vote voteCreate(@RequestBody Vote vote) {
		return voteRepository.save(vote);
	}

	@PutMapping("/votes/{id}")
	public Vote voteUpdate() {
		Vote voteToUpdate = voteRepository.findById(1L).get();
		voteToUpdate.setPost(voteToUpdate.getPost());
		voteToUpdate.setUser(voteToUpdate.getUser());
		voteToUpdate.setTimestamp(voteToUpdate.getTimestamp());
		voteToUpdate.setUpvote(voteToUpdate.isUpvote());
		return voteRepository.save(voteToUpdate);
	}

	@DeleteMapping("/votes/{id}")
	public void voteDelete(@PathVariable("id") Long id) {
		voteRepository.deleteById(id);
	}

	// Return all comments
	@GetMapping("/comments")
	public Iterable<Comment> commentAll() {
		return commentRepository.findAll();
	}

	@GetMapping("/comments/{id}")
	public Comment commentById(@PathVariable("id") Long id) {
		return commentRepository.findById(id).get();
	}

	@PostMapping("/comments")
	public Comment commentCreate(@RequestBody Comment comment) {
		return commentRepository.save(comment);
	}

	@PutMapping("/comments/{id}")
	public Comment commentUpdate(@PathVariable("id") Long id, @RequestBody Comment comment) {
		Comment commentToUpdate = commentRepository.findById(id).get();
		commentToUpdate.setPost(comment.getPost());
		commentToUpdate.setUser(comment.getUser());
		commentToUpdate.setDownvotes(comment.getDownvotes());
		commentToUpdate.setUpvotes(comment.getUpvotes());
		commentToUpdate.setText(comment.getText());
		return commentRepository.save(commentToUpdate);
	}

	@DeleteMapping("/comments/{id}")
	public void commentDelete(@PathVariable("id") Long id) {
		commentRepository.deleteById(id);
	}
}