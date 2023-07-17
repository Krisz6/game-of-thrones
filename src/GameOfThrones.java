import character.Character;
import character.Noble;
import character.type.Gender;
import character.type.House;
import combat.MeleeWeapon;
import combat.RangedWeapon;
import combat.type.FightType;
import combat.type.MeleeWeaponType;
import combat.type.RangedWeaponType;

import java.util.Set;

public class GameOfThrones {
    public static void main(String[] args) {
        Character arya = new Noble("Arya", "Winterfell", Gender.FEMALE, Set.of(House.STARK));
        System.out.println(arya.hasWeapons());
        arya.addWeapon(new MeleeWeapon("Valyrian steel dagger", 20, MeleeWeaponType.DAGGER));
        arya.addWeapon(new MeleeWeapon("Gendry's mace", 30, MeleeWeaponType.MACE));
        arya.addWeapon(new RangedWeapon("Stolen bow", 10, 40, 5, RangedWeaponType.BOW));
        arya.removeWeapon("Stolen bow");
        System.out.println(arya.getWeapons());



        System.out.println(arya.getGender());

        System.out.println(Character.getPopulation());

        Noble cersei = new Noble("Cersei", "Casterly Rock", Gender.FEMALE, Set.of(House.LANNISTER));
        cersei.addHouse(House.BARATHEON);
        cersei.addCoins("gold", 1); // 1 gold -> 100 copper
        cersei.addCoins("silver", 1);
        cersei.addCoins("silver", 2); // 1+2 silver -> 30 copper
        cersei.addCoins("copper", 3); // 3 copper -> 3 copper
        System.out.println(cersei); // Cersei of house [LANNISTER, BARATHEON] has 133 wealth in copper



        System.out.println(cersei);
        System.out.println(Character.getPopulation());

        arya.fight(cersei, FightType.MELEE);

        arya.die();
        System.out.println(Character.getPopulation());
        cersei.die();


    }
}
