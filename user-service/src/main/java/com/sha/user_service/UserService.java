package com.sha.user_service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public void save(User user){
        repository.save(user);
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    public List<User> findUsersByRole(Integer id) {
        return repository.findAllByRoleId(id);
    }
}
