package com.acme.graduates.demo.controller;

import com.acme.graduates.demo.domain.model.User;
import com.acme.graduates.demo.domain.service.UserService;
import com.acme.graduates.demo.resource.SaveUserResource;
import com.acme.graduates.demo.resource.UserResource;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService userService;

    @Operation(summary = "Get All user", description = "Get All available user", tags = {"user"})
    @GetMapping("/user")
    public Page<UserResource> getAllUser(Pageable pageable) {
        Page<User> userNoChef = userService.getAllUser(pageable);
        List<UserResource> resources = userNoChef.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get user By Id", description = "Get user for given Id", tags = {"user"})
    @GetMapping("/user/{id}")
    public UserResource getUserById(@PathVariable(name = "id") Long id){
        return convertToResource(userService.getUserById(id));
    }

    @Operation(summary = "Create user", description = "Create a new user", tags = {"user"})
    @PostMapping("/user")
    public UserResource createUser(@Valid @RequestBody SaveUserResource resource){
        User userNoChef = convertToEntity(resource);
        return convertToResource(userService.createUser(userNoChef));
    }

    @Operation(summary = "Update user", description = "Update user with given Id", tags = {"user"})
    @PutMapping("/user/{id}")
    public UserResource updateUserResource(@PathVariable(name = "id") Long userNoChefId,
                                                       @Valid @RequestBody SaveUserResource resource){
        return convertToResource(userService.updateUser(userNoChefId,convertToEntity(resource)));
    }

    @Operation(summary = "Delete user", description = "Delete user with given Id", tags = {"user"})
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable(name = "id")  Long id){
        return userService.deleteUser(id);
    }

    private User convertToEntity(SaveUserResource resource) {
        return mapper.map(resource, User.class);
    }

    private UserResource convertToResource(User entity) {
        return mapper.map(entity, UserResource.class);
    }
}
