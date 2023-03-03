package com.rahul.blog.app.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) // 02:08:33
	private int id;

	@Column(name = "username", nullable = false)
	private String name;

	@Column(name="email_id", nullable = false)
	private String email;
	@Column(name="password", nullable = false)
	private String password;
	@Column(name="about")
	private String about;
}
