package com.foodies.foodies.Repositories;


import com.foodies.foodies.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String email);
}
