package character;

import character.type.Gender;
import combat.Weapon;
import combat.type.FightType;

import java.util.*;

public class Character implements Mortal {
    private String name;
    private final String birthPlace;
    private Gender gender;

    private int health = 100;

    private final Set<Weapon> weapons = new HashSet<>();

    private static int population = 0;

    public static int getPopulation() {
        return population;
    }

    public Character(String name, String birthPlace, Gender gender) {
        this.name = name;
        this.birthPlace = birthPlace;
        this.gender = gender;
        population++;
    }

    public void setGender(Gender gender) {
        if (this.gender == Gender.MALE && gender == Gender.EUNUCH) {
            this.gender = gender; // vagy this.gender = Gender.EUNUCH
        }
    }

    public Gender getGender() {
        return this.gender;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthPlace() {
        return this.birthPlace;
    }

    @Override
    public void die() {
        population--;
    }

    public void addWeapon(Weapon weapon) {
        this.weapons.add(weapon);
    }

    public void removeWeapon(String weaponName) {
        Weapon weaponToRemove = null;
        for (Weapon weapon : this.weapons) {
            if (weapon.getName().equals(weaponName)) {
                weaponToRemove = weapon;
            }
        }
        this.weapons.remove(weaponToRemove);
    }

    public Set<Weapon> getWeapons() {
        return weapons;
    }

    public boolean hasWeapons() {
        return !this.weapons.isEmpty();
    }

    private void initiateFight(Weapon weapon, Character enemy, FightType fightType) {
        String fightTypeName = fightType == FightType.MELEE ? "melee" : "ranged";
        System.out.println(this.getName() + " engages in " + fightTypeName + " combat with " + enemy.getName() + ".");
        weapon.attack(this, enemy);
    }

    public void fight(Character enemy, FightType fightType) {
        if (this.hasWeapons()) {
            for (Weapon weapon : this.getWeapons()) {
                if ((fightType == FightType.MELEE && !weapon.isRanged()) ||
                        (fightType == FightType.RANGED && weapon.isRanged())) {
                    initiateFight(weapon, enemy, fightType);
                }
            }
        } else {
            System.out.println(this.getName() + " has no weapons to fight with.");
        }
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println(this.getName() + "'s health dropped to " + this.health + "/100.");
    }

    public int getHealth() {
        return this.health;
    }
}
