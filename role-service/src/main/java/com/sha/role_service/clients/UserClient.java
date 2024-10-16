package com.sha.role_service.clients;

import com.sha.role_service.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-service",url = "${application.config.service-url}")
public interface UserClient {

    @GetMapping("/get-user/{roleId}")
    List<User> findAllUsers(@PathVariable("roleId")Integer id);
}
