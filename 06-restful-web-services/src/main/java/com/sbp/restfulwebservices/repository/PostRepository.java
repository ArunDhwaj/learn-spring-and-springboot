package com.sbp.restfulwebservices.repository;

import com.sbp.restfulwebservices.user.Post;
import com.sbp.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
