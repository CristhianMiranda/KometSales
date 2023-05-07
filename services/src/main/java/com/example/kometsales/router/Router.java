package com.example.kometsales.router;

public class Router {
    private static final String API = "/api";

    public static class FlowerAPI {

        public static final String ROOT = API + "/request";

        public static final String GET_ALL_FLOWERS = "/flowers";

        public static final String SAVE_ALL_FLOWERS = "/flowers";

        public static final String PRICE_GREATER_THAN_20 = "/flowers/price-greater-than-20";

        public static final String DELETE_BY_ID = "/flowers/{id}";


        public static final String GET_BY_NAME = "/flowers/{name}";
    }
}
