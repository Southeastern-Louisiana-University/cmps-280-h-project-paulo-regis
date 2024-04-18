package battle_system.Movelist;

import battle_system.Characters.Fighter;
import battle_system.Statuses.CantFlee;
import battle_system.TypeList;

public class Flee extends Move {

    public Flee() {
        super("Flee",
                TypeList.NONE,
                Category.STATUS,
                0,
                0,
                new CantFlee());
    }

    @Override
    public void useMove(Move move, Fighter target) {
        // haha funny?
    }

    @Override
    public void useMove(Move move) {

    }
}
