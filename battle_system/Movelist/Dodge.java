package battle_system.Movelist;

import battle_system.Characters.Fighter;
import battle_system.Statuses.*;
import battle_system.TypeList;

public class Dodge extends Move {
    public Dodge() {
        super("Dodge",
                TypeList.NORMAL,
                Category.STATUS,
                0,
                100,
                new Dodging());
    }
}