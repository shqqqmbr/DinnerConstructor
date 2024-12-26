package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> lunches = new HashMap<>();
    Random random = new Random();

    void addNewDish(String dishType, String dishName) {
        if (checkType(dishType)) {
            ArrayList<String> types = lunches.get(dishType);
            types.add(dishName);
        } else {
            ArrayList<String> names = new ArrayList<>();
            names.add(dishName);
            lunches.put(dishType, names);
        }
    }

    void generateDishCombo(int numberOfCombos, ArrayList<String> types) {
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> lunchCombo = new ArrayList<>();
            for (String type : types) {
                int dishNumber = random.nextInt(lunches.get(type).size());
                String dishName = lunches.get(type).get(dishNumber);
                lunchCombo.add(dishName);
            }
            System.out.println("Комбо " + (i + 1));
            System.out.println(lunchCombo);
        }
    }

    boolean checkType(String type) {
        return lunches.containsKey(type);
    }
}
