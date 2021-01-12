package com.acme.graduates.demo.controller;

import com.acme.graduates.demo.domain.model.User;
import com.acme.graduates.demo.domain.service.UserService;
import com.acme.graduates.demo.resource.SaveUserResource;
import com.acme.graduates.demo.resource.PersonResource;
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
@CrossOrigin
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService userService;

    @Operation(summary = "Get All user", description = "Get All available user", tags = {"person"})
    @GetMapping("/person")
    public Page<PersonResource> getAllUser(Pageable pageable) {
        Page<User> userNoChef = userService.getAllUser(pageable);
        List<PersonResource> resources = userNoChef.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get user By Id", description = "Get user for given Id", tags = {"person"})
    @GetMapping("/person/{id}")
    public PersonResource getUserById(@PathVariable(name = "id") Long id){
        return convertToResource(userService.getUserById(id));
    }

    @Operation(summary = "Create user", description = "Create a new user", tags = {"person"})
    @PostMapping("/person")
    public PersonResource createUser(@Valid @RequestBody SaveUserResource resource){
        User userNoChef = convertToEntity(resource);
        return convertToResource(userService.createUser(userNoChef));
    }

    @Operation(summary = "Update user", description = "Update user with given Id", tags = {"person"})
    @PutMapping("/person/{id}")
    public PersonResource updateUserResource(@PathVariable(name = "id") Long userNoChefId,
                                             @Valid @RequestBody SaveUserResource resource){
        return convertToResource(userService.updateUser(userNoChefId,convertToEntity(resource)));
    }

    @Operation(summary = "Delete user", description = "Delete user with given Id", tags = {"person"})
    @DeleteMapping("/person/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable(name = "id")  Long id){
        return userService.deleteUser(id);
    }

    private User convertToEntity(SaveUserResource resource) {
        return mapper.map(resource, User.class);
    }

    private PersonResource convertToResource(User entity) {
        return mapper.map(entity, PersonResource.class);
    }
}
