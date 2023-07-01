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
    private double averageDailyIncomeVariation;

    public GraphicalPreview(List<DayData> daysData){

        List<LocalDate> dates = new ArrayList<>();
        double[] graphicValues = new double[daysData.size()*2];

        for(int i = 0; i < daysData.size(); i++){
            dates.add(daysData.get(i).getDate());
            graphicValues[i] = daysData.get(i).getTotalBalanceVariance();
        }

        double averageIncomeVariation = daysData.get(0).getTotalBalanceVariance();

        for(int i = 1; i < daysData.size(); i++){
            averageIncomeVariation = (averageIncomeVariation + daysData.get(i).getTotalBalanceVariance())/2; 
        }

        this.averageDailyIncomeVariation = averageIncomeVariation;

        for(int i = 0; i < daysData.size(); i++){
            dates.add(daysData.get(i).getDate().plusDays(30));
            graphicValues[i + daysData.size()] = this.averageDailyIncomeVariation;
        }

        this.labels = dates;
        this.values = graphicValues;
    }
}