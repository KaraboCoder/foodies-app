package com.foodies.foodies.Repositories;

import com.foodies.foodies.Models.Units;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitsRepository extends CrudRepository<Units, Long> {
}
