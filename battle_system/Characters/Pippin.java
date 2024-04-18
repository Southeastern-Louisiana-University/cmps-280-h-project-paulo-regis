package battle_system.Characters;

import battle_system.TypeList;
import battle_system.Movelist.*;

public class Pippin extends Fighter {

    public Pippin() {
        super("Pippin",
                TypeList.GRASS,
                0,
                0,
                0,
                0, // high spa
                0, // high spd
                0,
                null,
                null,
                new Block("Best Boy Block"));
    }
}
