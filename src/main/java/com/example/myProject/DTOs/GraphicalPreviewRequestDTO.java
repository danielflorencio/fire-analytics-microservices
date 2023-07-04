package com.example.myProject.DTOs;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GraphicalPreviewRequestDTO {
    
    private LocalDate startDate;
    private LocalDate endDate; 




}