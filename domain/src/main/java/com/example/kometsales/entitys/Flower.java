package com.example.kometsales.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Flower implements Serializable {



    @EqualsAndHashCode.Include
    private Long id;

    @EqualsAndHashCode.Include
    private String name;

    private Double price;

}
