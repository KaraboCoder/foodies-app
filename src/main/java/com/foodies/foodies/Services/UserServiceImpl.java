package com.foodies.foodies.Services;

import com.foodies.foodies.Models.Users;
import com.foodies.foodies.Repositories.RoleRepository;
import com.foodies.foodies.Repositories.UsersRepository;
import com.foodies.foodies.Services.contracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void save(Users user) {
        user.setPassword(user.getPassword());
        user.setRoles("User");
        userRepository.save(user);
    }

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
