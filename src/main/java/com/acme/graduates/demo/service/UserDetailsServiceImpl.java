package com.acme.graduates.demo.service;

import com.acme.graduates.demo.domain.service.DefaultUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements DefaultUserDetailsService {
    private static final String DEFAULT_USERNAME = "john.doe@gmail.com";
    private static final List<GrantedAuthority> DEFAULT_AUTHORITIES = new ArrayList<>();

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAll() {
        // TODO: Replace by Repository-based Implementation
        return Arrays.asList(
                new User("john.doe@gmail.com",
                        passwordEncoder.encode("password"),
                        DEFAULT_AUTHORITIES),
                new User("jason.bourne@treatstone.gov",
                        passwordEncoder.encode("easy-one"),
                        DEFAULT_AUTHORITIES)
        );
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String defaultPassword = passwordEncoder.encode("password");
        if(DEFAULT_USERNAME.equals(username)) {
            return new User(DEFAULT_USERNAME, defaultPassword, DEFAULT_AUTHORITIES);
        }
        throw new UsernameNotFoundException(String.format("User not found with username %s", username));
    }
}
