package paulomon.Movelist;

import paulomon.Characters.Fighter;
import paulomon.TypeList;

public class Regenerate extends Move {

    public Regenerate() {
        super("Regenerate",
                "Scientifically heals an ally!",
                TypeList.WATER,
                Category.STATUS,
                -50,
                100,
                null,
                true);
    }

    @Override
    public void useMove(Fighter attacker, Fighter target) {
        target.modifyHp(-getPower());
//        System.out.println(attacker.getName() + " uses " + getName() + " on " + target.getName() + "! ("+target.getHpCurrent()+"/"+target.getHpMax()+")");
    }
}
