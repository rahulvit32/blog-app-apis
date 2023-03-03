package com.rahul.blog.app.repositories;

import com.rahul.blog.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {


}
