package com.foodies.foodies.Repositories;


import com.foodies.foodies.Models.RecipeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeUserRepository extends JpaRepository<RecipeUser, Long> {

}
