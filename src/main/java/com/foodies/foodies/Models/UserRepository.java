package com.foodies.foodies.Models;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long> {
    @Override
    Iterable<User> findAll();
}
