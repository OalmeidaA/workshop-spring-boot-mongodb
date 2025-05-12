package com.udemy.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Transactional
	public User update(User obj, String id) {
		User newUser = repository.findById(obj.getId())
				.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado para atualização!"));

		updateData(newUser, obj);

		return repository.save(newUser);
	}

	public void updateData(User newUser, User obj) {
		newUser.setName(obj.getName());
		newUser.setEmail(obj.getEmail());
	}

	public User fromDto(UserDto objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
