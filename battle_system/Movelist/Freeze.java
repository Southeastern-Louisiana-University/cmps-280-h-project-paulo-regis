package battle_system.Movelist;

import battle_system.Characters.*;
import battle_system.Statuses.*;
import battle_system.TypeList;

public class Freeze extends Move {

    public Freeze() {
        super("Freeze",
                TypeList.ICE,
                Category.STATUS,
                25,
                50,
                new Frozen());
    }

    @Override
    public void useMove(Fighter attacker, Fighter target) {
        target.takeDamage(attacker, getPower(), getType(), getCategory());
        if (target.compareTo(new Nova(null)) == 0) {
            System.out.println("Nova is immune to being Frozen!");
        } else {
            getInflicts().applyEffect(target);
        }
    }

    public void useMove(Fighter attacker, Fighter[] targetList) {
        for (Fighter target : targetList) {
            target.takeDamage(attacker, getPower(), getType(), getCategory());
            if (target.compareTo(new Nova(null)) == 0) {
                System.out.println("Nova is immune to being Frozen!");
            } else {
                getInflicts().applyEffect(target);
            }
        }
    }
}
