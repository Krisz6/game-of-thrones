package combat;

import character.Character;
import combat.type.RangedWeaponType;

public class RangedWeapon extends Weapon {
    RangedWeaponType type;
    int ammunition;

    public RangedWeapon(String name, int damage, int range, int ammunition, RangedWeaponType type) {
        super(name, damage, range);
        this.type = type;
        this.ammunition = ammunition;
    }

    @Override
    public void attack(Character character, Character enemy) {
        if (ammunition > 0) {
            enemy.takeDamage(this.damage);
            ammunition--;
        } else {
            System.out.println(character.getName() + "has no ammunition for" + this.name + "to fight with");
        }
    }

    @Override
    public boolean isRanged() {
        return true;
    }

    @Override
    public String toString() {
        return "RangedWeapon{" +
                "ammunition=" + ammunition +
                ", name='" + name + '\'' +
                ", damage=" + damage +
                ", range=" + range +
                '}';
    }
}
