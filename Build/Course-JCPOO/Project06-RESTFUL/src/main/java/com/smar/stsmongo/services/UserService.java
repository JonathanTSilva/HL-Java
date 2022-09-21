package com.smar.stsmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smar.stsmongo.domain.User;
import com.smar.stsmongo.repository.UserRepository;

@Service
public class UserService {

    @Autowired //Injeção de dependência automática
    private UserRepository repo;
    
    public List<User> findAll() {
        return repo.findAll();
    }
}