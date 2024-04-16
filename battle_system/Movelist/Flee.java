package battle_system.Movelist;

import battle_system.TypeList;

public class Flee extends Move {

    public Flee() {
        super("Flee",
                TypeList.NONE,
                Category.STATUS,
                0,
                0,
                "You can't flee from a trainer battle!");
    }
}
