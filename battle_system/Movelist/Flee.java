package battle_system.Movelist;

import battle_system.Statuses.Fleeing;
import battle_system.TypeList;

public class Flee extends Move {

    public Flee() {
        super("Flee",
                TypeList.NORMAL,
                Category.STATUS,
                0,
                0,
                new Fleeing(),
                false);
    }
}
