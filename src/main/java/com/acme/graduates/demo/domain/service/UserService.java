package com.acme.graduates.demo.domain.service;

import com.acme.graduates.demo.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface UserService {
    Page<User> getAllUser(Pageable pageable);

    User getUserById (Long userId);

    User createUser (User user);

    User updateUser (Long userId, User user);

    ResponseEntity<?> deleteUser(Long userId);
}
