package com.foodies.foodies.Repositories;

import com.foodies.foodies.Models.Units;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitsRepository extends JpaRepository<Units, Long> {

}
