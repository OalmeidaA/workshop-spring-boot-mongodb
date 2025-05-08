package com.udemy.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	
	@GetMapping
	public ResponseEntity<List<User>>  findAll() {
		User henrique = new User("1", "Henrique Alves", "rick@gmail.com");
		User gustavo = new User("2", "Gustavo Alves", "gustavo@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(henrique, gustavo));
		return ResponseEntity.ok().body(list);
	}
}
