package com.example.myProject.models;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GraphicalPreview {
    
    private List<LocalDate> labels;
    private double[] values;

    public GraphicalPreview(List<DayData> daysData){

        List<LocalDate> dates = new ArrayList<>();
        double[] graphicValues = new double[daysData.size()];

        for(int i = 0; i < daysData.size(); i++){
            dates.add(daysData.get(i).getDate());
            graphicValues[i] = daysData.get(i).getTotalBalanceVariance();
        }

        this.labels = dates;
        this.values = graphicValues;
    }
}