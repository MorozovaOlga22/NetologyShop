package ru.netology;

import ru.netology.products.Clothes;
import ru.netology.products.Food;
import ru.netology.products.HouseholdChemicals;
import ru.netology.products.Product;

import java.util.HashMap;
import java.util.Map;

public class ShopUtils {
    private static final Map<String, Product> productsMap = getProductsMap();

    private static Map<String, Product> getProductsMap() {
        final Map<String, Product> productsMap = new HashMap<>();
        productsMap.put("0", new Food("Гречка", 200, "10.01.2022"));
        productsMap.put("1", new Food("Йогурт", 100, "10.10.2021"));
        productsMap.put("2", new Clothes("Кофта", 3000, 46));
        productsMap.put("3", new Clothes("Носки", 200, 38));
        productsMap.put("4", new HouseholdChemicals("Мыло", 500, false));
        productsMap.put("5", new HouseholdChemicals("Чистящее средство", 1_000, true));

        return productsMap;
    }

    public static Product getProductByCode(String code) {
        return productsMap.get(code);
    }

    public static void printAllProducts() {
        productsMap.forEach((code, product) -> System.out.println("Код товара: " + code + "; товар: " + product));
    }
}
