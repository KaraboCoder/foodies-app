package com.foodies.foodies.Repositories;

import com.foodies.foodies.Models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {

}
