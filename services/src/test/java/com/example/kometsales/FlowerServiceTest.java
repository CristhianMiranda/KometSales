package com.example.kometsales;

import com.example.kometsales.entitys.Flower;
import com.example.kometsales.entitys.FlowerList;
import com.example.kometsales.exceptions.FlowersListNotFoundException;
import com.example.kometsales.exceptions.FlowersSaveException;
import com.example.kometsales.exceptions.PriceGreaterThanTwentyException;
import com.example.kometsales.implementation.FlowerServicesImplementation;
import com.example.kometsales.services.FlowerServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class FlowerServiceTest {

    @Autowired
    private FlowerServices flowerServices;



    @Test
    void saveFlowersTest() throws FlowersSaveException {

        List<Flower> flowers = new ArrayList<>();

        Flower flower = new Flower(1L,"rose",25.0);
        Flower flower2 = new Flower(2L,"orquidea",21.0);

        flowers.add(flower);
        flowers.add(flower2);

        flowerServices.saveFlowers(flowers);

        Assertions.assertTrue(FlowerList.getFlowers().containsAll(flowers));

    }

    @Test
    void getAllFlowersTest() throws FlowersListNotFoundException, FlowersSaveException {
        List<Flower> flowers = new ArrayList<>();

        Flower flower = new Flower(1L,"rose",25.0);
        Flower flower2 = new Flower(2L,"orquidea",21.0);

        flowers.add(flower);
        flowers.add(flower2);

        flowerServices.saveFlowers(flowers);

        Assertions.assertFalse(flowerServices.getAllFlowers().isEmpty());
    }


}
