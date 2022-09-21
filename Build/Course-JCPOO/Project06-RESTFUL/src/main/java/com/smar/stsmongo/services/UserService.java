package com.smar.stsmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smar.stsmongo.domain.User;
import com.smar.stsmongo.dto.UserDTO;
import com.smar.stsmongo.repository.UserRepository;
import com.smar.stsmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired //Injeção de dependência automática
    private UserRepository repo;
    
    public List<User> findAll() {
        return repo.findAll();
    }
    
    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
    
    public User insert(User obj) {
        return repo.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }
    
    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}