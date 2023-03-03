package com.rahul.blog.app.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private  int id;
    private String username;
    private String email_id;
    private String password;
    private String about;

}
