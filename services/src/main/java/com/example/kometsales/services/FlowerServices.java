package com.example.kometsales.services;

import com.example.kometsales.entitys.Flower;
import com.example.kometsales.exceptions.*;

import java.util.List;
import java.util.Map;

public interface FlowerServices {
    void saveFlowers(List<Flower> flowers) throws FlowersSaveException;

    List<Map<String, Object>> getAllFlowers() throws FlowersListNotFoundException;

    List<Flower> getFlowersWithPriceGreaterThan20() throws PriceGreaterThanTwentyException;

    Boolean deleteFlower(Long id) throws FlowerNotFoundException;

    List<Flower> getFlowersByName(String name) throws FlowerException;

}