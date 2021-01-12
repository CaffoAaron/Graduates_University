package com.acme.graduates.demo.domain.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface DefaultUserDetailsService extends UserDetailsService {
    public List<User> getAll();
}
