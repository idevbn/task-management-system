package com.idevbn.taskmanagementsystem.services;

import com.idevbn.taskmanagementsystem.entities.User;
import com.idevbn.taskmanagementsystem.repositories.UserRepository;
import com.idevbn.taskmanagementsystem.services.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    public User create(User user) {
        Optional<User> userOptional = repository.findByEmail(user.getEmail());

        if (userOptional.isPresent()) {
            throw new BadRequestException("Email already exists.");
        }

        User userObj = new User();

        userObj.setName(user.getName());
        userObj.setEmail(user.getEmail());
        userObj.setTasks(user.getTasks());

        return repository.save(userObj);
    }
}
