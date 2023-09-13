package edu.wctc.streetfood;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MenuItem {
    private int id;
    private String name;
    private String description;
    private String imageFileName;
    private double price;
}
