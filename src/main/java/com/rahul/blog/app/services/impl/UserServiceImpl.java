package com.rahul.blog.app.services.impl;

import com.rahul.blog.app.entities.User;
import com.rahul.blog.app.exceptions.ResourceNotFoundException;
import com.rahul.blog.app.payloads.UserDto;
import com.rahul.blog.app.repositories.UserRepo;
import com.rahul.blog.app.services.UserService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User saveUser = this.userRepo.save(user);
        return this.userToDto(saveUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user  = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User"," Id ",userId));
        user.setName(userDto.getUsername());
        user.setEmail(userDto.getEmail_id());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());

        User updatedUser = this.userRepo.save(user);
        UserDto userDto1 = this.userToDto(updatedUser);
        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User"," Id ",userId));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();

        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user))
                .collect(Collectors.toList());

        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User"," Id ",userId));
        this.userRepo.delete(user);
    }


    public User dtoToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getUsername());
        user.setEmail(userDto.getEmail_id());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDto userToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getName());
        userDto.setEmail_id(user.getEmail());
        userDto.setAbout(user.getAbout());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

}