package paulomon.Movelist;

import paulomon.Characters.*;
import paulomon.Statuses.*;
import paulomon.TypeList;

public class Freeze extends Move {

    public Freeze() {
        super("Freeze",
                "A frigid blast that locks enemies in place.",
                TypeList.ICE,
                Category.STATUS,
                25,
                50,
                new Frozen(),
                false);
    }

    @Override
    public void useMove(Fighter attacker, Fighter target) {
        if (target.compareTo(new Nova(null)) == 0) {
            System.out.println("Nova is immune to being Frozen!");
        } else {
            target.takeDamage(attacker, getPower(), getType(), getCategory());
            getInflicts().applyEffect(target);
        }
    }

    public void useMove(Fighter attacker, Fighter[] targetList) {
        for (Fighter target : targetList) {
            useMove(attacker, target);
        }
    }
}
