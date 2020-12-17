package ru.flendger.spring.demo.models;

import lombok.*;

@Data
@NoArgsConstructor
public class Product {
    private Long id;
    private String title;
    @Setter(AccessLevel.NONE) private Float price;

    public void setPrice(float price) {
        this.price = (float) Math.round(price * 100)/100;
    }
}
