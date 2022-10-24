package ru.samd82.mymarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;
    private String title;
    private Float cost;

    public Float getScore() {
        return cost;
    }

    public void setScore(Float cost) {
        this.cost = cost;
    }


}
