package com.example.Ecommerce.Project.service;

import com.example.Ecommerce.Project.model.category;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface Categoryservice {

    String deletecategory(Long categoryId);
    List<category> getAllCategory();
    void createcategory(category categoryy);
    category updatecategory(category categoryy, Long categoryId);
}
