package character;

import character.type.Gender;
import character.type.House;

import java.util.*;

public class Noble extends Character {

    private final Set<House> houses = new HashSet<>();
    private final Map<String, Integer> coins = new HashMap<>();

    public Noble(String name, String birthPlace, Gender gender, Set<House> houses) {
        super(name, birthPlace, gender);
        this.houses.addAll(houses);
    }

    public void addCoins(String coinType, int amount) {
        int currentAmount = coins.getOrDefault(coinType, 0);
        coins.put(coinType, currentAmount + amount);
    }

    public void removeCoins(String coinType, int amount) {
        int currentAmount = coins.getOrDefault(coinType, 0);
        int updatedAmount = currentAmount - amount;

        if (updatedAmount < 0) {
            System.out.println("Insufficient coins of type " + coinType);
        } else if (updatedAmount == 0) {
            coins.remove(coinType);
        } else {
            coins.put(coinType, updatedAmount);
        }
    }

    public int getWealth() {
        int totalWealth = 0;
        for (Map.Entry<String, Integer> entry : coins.entrySet()) {
            String coinType = entry.getKey();
            int amount = entry.getValue();

            switch (coinType) {
                case "gold" -> totalWealth += amount * 100;
                case "silver" -> totalWealth += amount * 10;
                case "copper" -> totalWealth += amount;
            }
        }
        return totalWealth;
    }


    public void addHouse(House house) {
        houses.add(house);
    }

    public void removeHouse(House house) {
        houses.remove(house);
    }

    public String getHousesAsString() {
        return houses.toString().substring(1, houses.toString().length() - 1);
    }

    @Override
    public String toString() {
        return this.getName() + " of house(s) " + getHousesAsString() + " has " + getWealth() + "  wealth in copper.";
    }

    @Override
    public void die() {
        super.die();
        houses.forEach(h -> System.out.println(h.getWordsInEnglish()));
    }
}
