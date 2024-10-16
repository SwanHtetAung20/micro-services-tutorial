package com.sha.role_service;

import com.sha.role_service.clients.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository repository;
    private final UserClient client;

    public void save(Role role){
        repository.save(role);
    }

    public List<Role> findAll(){
        return repository.findAll();
    }

    public Response findById(Integer id) {
        var role = repository.findById(id).orElse(Role.builder().name("Not Found").build());
        var users = client.findAllUsers(id);
        return Response.builder()
                .name(role.getName())
                .users(users)
                .build();
    }
}
