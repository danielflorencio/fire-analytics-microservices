package com.example.myProject.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.myProject.models.NumericalPreview;

public interface NumericalPreviewRepository extends JpaRepository<NumericalPreview, Long>{
    
}
