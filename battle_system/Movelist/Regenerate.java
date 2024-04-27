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
                null);
    }

    @Override
    public void useMove(Fighter attacker, Fighter target) {
        target.modifyHp(-getPower());
    }
}
