package com.example.Ecommerce.Project.service;

import com.example.Ecommerce.Project.model.category;
import com.example.Ecommerce.Project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryserviceImp implements Categoryservice{

    //private List<category> categories = new ArrayList<>();
    private Long nextId = 1L;

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public String deletecategory(Long categoryId) {
        category category = categoryRepository.findById(categoryId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resorce not found"));

        categoryRepository.delete(category);
        return "Category with categoryID: "+ categoryId + " deleted succesfully !!";
    }

    @Override
    public List<category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void createcategory(category categoryy) {
        //categoryy.setCategoryID(nextId++);
        categoryRepository.save(categoryy);
    }

    @Override
    public category updatecategory(category categoryy, Long categoryId) {
        Optional<category> savedcategoryoptional = categoryRepository.findById(categoryId);
        category savedcategory = savedcategoryoptional.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not Found"));
        categoryy.setCategoryID(categoryId);
        savedcategory= categoryRepository.save(categoryy);
        return savedcategory;
    }
}
