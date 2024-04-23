package battle_system.Movelist;

import battle_system.Characters.Fighter;
import battle_system.Statuses.CantFlee;
import battle_system.TypeList;

public class Flee extends Move {

    public Flee() {
        super("Flee",
                TypeList.NORMAL,
                Category.STATUS,
                0,
                0,
                new CantFlee());
    }

    @Override
    public void useMove(Fighter target) {
        // haha funny?
    }

    @Override
    public void useMove() {

    }
}
