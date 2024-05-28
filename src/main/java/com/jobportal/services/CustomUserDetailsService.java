package com.jobportal.services;

import com.jobportal.entity.Users;
import com.jobportal.repository.UsersRepository;
import com.jobportal.util.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UsersRepository usersRepository;
    @Autowired
    public CustomUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Users users = usersRepository.findByEmail(userName).orElseThrow(()->new UsernameNotFoundException("Could not find user " + userName));
        return new CustomUserDetails(users);
    }

}
