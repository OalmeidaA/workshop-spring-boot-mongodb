package com.udemy.workshopmongo.services;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.workshopmongo.domain.User;
import com.udemy.workshopmongo.dto.UserDto;
import com.udemy.workshopmongo.repository.UserRepository;
import com.udemy.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	@Transactional(readOnly = true)
	public List<User> findAll(){
		return repository.findAll();
	}
	
	@Transactional(readOnly = true)
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
	
	@Transactional
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	@Transactional
	public void delete(String id) { 
		if(!repository.existsById(id)){ 
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		repository.deleteById(id);
	}

	public User fromDto(UserDto objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
