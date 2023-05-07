package com.example.kometsales.controllers;


import com.example.kometsales.entitys.Flower;
import com.example.kometsales.entitys.FlowerList;
import com.example.kometsales.exceptions.FlowersListNotFoundException;
import com.example.kometsales.exceptions.FlowersSaveException;
import com.example.kometsales.exceptions.PriceGreaterThanTwentyException;
import com.example.kometsales.services.FlowerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import static com.example.kometsales.entitys.FlowerList.flowers;
import static com.example.kometsales.router.Router.FlowerAPI.*;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(ROOT)
public class FlowerController {

    final
    FlowerServices flowerServices;

    public FlowerController(FlowerServices flowerServices) {
        this.flowerServices = flowerServices;
    }

    @PostMapping(SAVE_ALL_FLOWERS)
    @ResponseStatus(OK)
    public void saveFlowers(@RequestBody List<Flower> flowers) throws FlowersSaveException {
        flowerServices.saveFlowers(flowers);
    }

    @GetMapping(GET_ALL_FLOWERS)
    public List<Map<String, Object>> getAllFlowers() throws FlowersListNotFoundException {
        return flowerServices.getAllFlowers();
    }


    @GetMapping(PRICE_GREATER_THAN_20)
    public List<Flower> getFlowersWithPriceGreaterThan20() throws PriceGreaterThanTwentyException {
        return flowerServices.getFlowersWithPriceGreaterThan20();
    }

    @DeleteMapping(DELETE_BY_ID)
    public ResponseEntity<String> deleteFlower(@PathVariable long id) {
        if (flowerServices.deleteFlower(id)) {
            return ResponseEntity.ok("Flower with id " + id + " has been deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flower with id " + id + " not found");
        }
    }

    @GetMapping(GET_BY_NAME)
    public List<Flower> getFlowersByName(@PathVariable String name) {
        return flowerServices.getFlowersByName(name);
    }

}