package com.foodies.foodies.Repositories;


import com.foodies.foodies.Models.Instructions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionsRepository extends JpaRepository<Instructions, Long> {

}
