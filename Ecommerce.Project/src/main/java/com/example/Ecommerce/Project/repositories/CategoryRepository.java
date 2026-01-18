package com.example.Ecommerce.Project.repositories;

import com.example.Ecommerce.Project.model.category;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryRepository extends JpaRepository<category,Long> {
}
