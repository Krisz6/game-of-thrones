package combat;

import character.Character;
import combat.type.MeleeWeaponType;

public class MeleeWeapon extends Weapon {
    MeleeWeaponType type;

    public MeleeWeapon(String name, int damage, MeleeWeaponType type) {
        super(name, damage, 1);
        this.type = type;
    }

    @Override
    public void attack(Character character, Character enemy) {
        System.out.println(
                character.getName() + " attacks with " + this.name + " and deals " +
                        this.damage + " damage to " + enemy.getName() + "."
        );
        enemy.takeDamage(this.damage);
    }

    @Override
    public boolean isRanged() {
        return false;
    }

    @Override
    public String toString() {
        return "MeleeWeapon{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", damage=" + damage +
                ", range=" + range +
                '}';
    }
}
