package com.foodies.foodies.Services.contracts;

import com.foodies.foodies.Models.Users;

public interface UserService {
    void save(Users user);

    Users findByEmail(String email);

}
