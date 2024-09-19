package com.app.app.categoria.web.controller;

import com.app.app.categoria.domain.service.ICategory;
import com.app.app.categoria.persistence.Category;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.app.consts.GeneralConst.ID_IN_PATH;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategory service;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(ID_IN_PATH)
    public ResponseEntity<Category> getCategoryByid(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        return ResponseEntity.ok(service.save(category));
    }

    @PutMapping(ID_IN_PATH)
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category){
        System.out.println("------------------------------" + id);
        System.out.println("---------------" + category);
        return ResponseEntity.ok(service.update(id, category));
    }

    @DeleteMapping(ID_IN_PATH)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
