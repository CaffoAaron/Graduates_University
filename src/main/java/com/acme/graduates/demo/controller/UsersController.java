package com.acme.graduates.demo.controller;

import com.acme.graduates.demo.domain.service.DefaultUserDetailsService;
import com.acme.graduates.demo.resource.UserResource;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private DefaultUserDetailsService userDetailsService;

    @Operation(summary = "Get All user", description = "Get All available user", tags = {"user"})
    @GetMapping
    public List<UserResource> getAll() {
        return userDetailsService.getAll().stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
    }

    private UserResource convertToResource(User user) {
        return mapper.map(user, UserResource.class);
    }
}
