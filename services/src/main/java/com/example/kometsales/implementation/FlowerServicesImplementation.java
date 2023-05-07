package com.example.kometsales.implementation;

import com.example.kometsales.entitys.Flower;
import com.example.kometsales.entitys.FlowerList;
import com.example.kometsales.exceptions.*;
import com.example.kometsales.services.FlowerServices;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.example.kometsales.entitys.FlowerList.flowers;

@Service
public class FlowerServicesImplementation implements FlowerServices {

    @Override
    public void saveFlowers(List<Flower> flowers) throws FlowersSaveException {
        try {
            for (Flower flower : flowers) {
                FlowerList.addFlower(flower);
            }
        } catch (Exception e) {
            throw new FlowersSaveException("Error saving the flowers: " + e.getMessage());
        }
    }


    @Override
    public List<Map<String, Object>> getAllFlowers() throws FlowersListNotFoundException {
        // Sort the list alphabetically in descending order
        Comparator<Flower> nameComparator = Comparator.comparing(Flower::getName).reversed();
        List<Flower> sortedFlowers = flowers.stream().sorted(nameComparator).collect(Collectors.toList());

        // Concatenate the word '-kometsales' at the end of each flower name"
        List<Map<String, Object>> result = new ArrayList<>();
        for (Flower flower : sortedFlowers) {
            Map<String, Object> flowerMap = new HashMap<>();
            flowerMap.put("name", flower.getName() + "-kometsales");
            flowerMap.put("price", flower.getPrice());
            result.add(flowerMap);
        }

        if (result.isEmpty()) {
            throw new FlowersListNotFoundException("No available flowers were found");
        }

        return result;
    }


    @Override
    public List<Flower> getFlowersWithPriceGreaterThan20() throws PriceGreaterThanTwentyException {
        List<Flower> allFlowers = FlowerList.getFlowers();
        List<Flower> result = new ArrayList<>();

        for (Flower flower : allFlowers) {
            if (flower.getPrice() > 20) {
                result.add(flower);
            }
        }

        if (result.isEmpty()) {
            throw new PriceGreaterThanTwentyException("There are no flowers with a price higher than 20");
        }

        return result;
    }

    @Override
    public Boolean deleteFlower(Long id) throws FlowerNotFoundException {
        if (FlowerList.deleteFlower(id)) {
            return true;
        } else {
            throw new FlowerNotFoundException(id);
        }
    }

    @Override
    public List<Flower> getFlowersByName(String name) throws FlowerException {
        try {
            List<Flower> filteredFlowers = new ArrayList<>();
            for (Flower flower : FlowerList.getFlowers()) {
                if (flower.getName().equals(name)) {
                    filteredFlowers.add(flower);
                }
            }
            if (filteredFlowers.isEmpty()) {
                throw new FlowerException("No flowers were found with the name " + name);
            }
            return filteredFlowers;
        } catch (Exception e) {
            throw new FlowerException("Error retrieving flowers by name", e);
        }
    }

}
