package battle_system.Movelist;

import battle_system.Characters.Fighter;
import battle_system.TypeList;

public class VineWhip extends Move {
    public VineWhip() {
        super("Vine Whip",
                TypeList.GRASS,
                Category.SPECIAL,
                100,
                100,
                null,
                false);
    }
}
