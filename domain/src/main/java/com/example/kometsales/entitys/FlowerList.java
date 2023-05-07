package com.example.kometsales.entitys;

import java.util.ArrayList;
import java.util.List;

public class FlowerList {
    public static List<Flower> flowers = new ArrayList<>();

    public static void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public static List<Flower> getFlowers() {
        return flowers;
    }

    public static boolean deleteFlower(long id) {
        return flowers.removeIf(flower -> flower.getId() == id);
    }

}
