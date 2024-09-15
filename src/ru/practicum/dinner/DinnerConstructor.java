package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {

    Random random = new Random();

    HashMap<String, ArrayList<String>> typeToDishes = new HashMap<>();

    public void addDish(String dishType, String dishName) {

        if (!typeToDishes.containsKey(dishType)) {
            ArrayList<String> dishList = new ArrayList<>();
            typeToDishes.put(dishType, dishList);
        }
        ArrayList<String> dishList = typeToDishes.get(dishType);
        dishList.add(dishName);
    }

    public ArrayList<ArrayList<String>> generateCombos(ArrayList<String> categoryList) {

        ArrayList<ArrayList<String>> combos = new ArrayList<>();

        ArrayList<String> currentCombo = new ArrayList<>();

        for (String dishType : categoryList) {
            ArrayList<String> availableDishes = typeToDishes.get(dishType);
            int size = availableDishes.size();

            int position = random.nextInt(size);

            String randomDish = availableDishes.get(position);
            currentCombo.add(randomDish);
        }

        combos.add(currentCombo);

        return combos;
    }

    public boolean checkType(String type) {
        return typeToDishes.containsKey(type);
    }
}

