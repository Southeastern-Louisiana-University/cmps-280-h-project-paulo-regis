package battle_system.Movelist;

import battle_system.TypeList;

public class Dodge extends Move {

    public Dodge() {
        super("Dodge",
                TypeList.NONE,
                Category.STATUS,
                0,
                100,
                "Dodge");
    }
}
