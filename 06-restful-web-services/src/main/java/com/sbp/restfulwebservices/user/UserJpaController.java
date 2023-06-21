package com.sbp.restfulwebservices.user;

import com.sbp.restfulwebservices.repository.PostRepository;
import com.sbp.restfulwebservices.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaController {

    private UserRepository repository;
    private PostRepository postRepository;

    public UserJpaController(UserRepository repository, PostRepository postRepository) {
        this.repository = repository;
        this.postRepository = postRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers()
    {
        return repository.findAll();
    }

    //HATEOAS implementation
    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> findUser(@PathVariable int id)
    {
       Optional<User> user = repository.findById(id);

       if(user.isEmpty())
            throw new UserNotFoundException("id: " + id);

        EntityModel<User> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id)
    {
        Optional<User> user = repository.findById(id);

        if(user.isEmpty())
            throw new UserNotFoundException("id: " + id);

//        System.out.println("user: " + user  + ", user.get(): " + user.get());
//        System.out.println("user.get().getPots(): " + user.get().getPosts());

       return user.get().getPosts();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        repository.deleteById(id);
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser( @Valid @RequestBody User user)
    {
       User savedUser =  repository.save(user);
       URI location = ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(savedUser.getId())
               .toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser( @PathVariable int id, @Valid @RequestBody Post post)
    {
        Optional<User> user = repository.findById(id);

        if(user.isEmpty())
            throw new UserNotFoundException("id: " + id);

        post.setUser(user.get());
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
