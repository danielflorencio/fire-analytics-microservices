package com.example.myProject.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.myProject.models.NumericalPreview;
import com.example.myProject.repositories.NumericalPreviewRepository;

@RestController
@RequestMapping("food")
public class NumericalPreviewController {

    @Autowired
    private NumericalPreviewRepository repository;

    @GetMapping    
    public List<NumericalPreview> getAll(){
        List<NumericalPreview> foodList = repository.findAll();
        return foodList;
    }
}
