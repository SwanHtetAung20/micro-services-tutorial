package com.sha.role_service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/roles")
public class RoleController {

    private final RoleService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Role role){
        service.save(role);
    }

    @GetMapping
    public ResponseEntity<List<Role>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/get-role/{roleId}")
    public ResponseEntity<Response> findRoleById(@PathVariable("roleId")Integer id){
        return ResponseEntity.ok(service.findById(id));
    }
}
