package com.example.Ecommerce.Project.controller;

import com.example.Ecommerce.Project.model.category;
import com.example.Ecommerce.Project.service.Categoryservice;
import com.example.Ecommerce.Project.service.CategoryserviceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryserviceImp Category;

    //@GetMapping("/api/public/categories")
    @RequestMapping(value = "/public/categories",method = RequestMethod.GET)
    public ResponseEntity<List<category>> getAllCategory()
    {
        List<category> category = Category.getAllCategory();
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    public ResponseEntity<String> createcategory(@RequestBody category categoryy)
    {
        Category.createcategory(categoryy);
        return new ResponseEntity<>(" Category added sucessfully ",HttpStatus.CREATED);
    }

    @DeleteMapping("/public/categories/{categoryId}")
    public ResponseEntity<String> deletecategory(@PathVariable Long categoryId)
    {
        try {
            String status = Category.deletecategory(categoryId);
            return new ResponseEntity<>(status, HttpStatus.OK);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<String> updatecategory(@RequestBody category categoryy,@PathVariable Long categoryId){
        try{
            category savedcategory = Category.updatecategory(categoryy,categoryId);
            return new ResponseEntity<>("CategoryUpdate with categoryId : "+categoryy, HttpStatus.OK);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }
}
