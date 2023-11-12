package com.just.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Good {
    private Integer id;
    private Integer shopId;
    private String name;
    private String description;
    private Double price;
}
