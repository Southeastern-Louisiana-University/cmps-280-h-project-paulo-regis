package battle_system.Movelist;

import battle_system.Characters.Fighter;
import battle_system.TypeList;

public class Regenerate extends Move {

    public Regenerate() {
        super("Regenerate",
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
