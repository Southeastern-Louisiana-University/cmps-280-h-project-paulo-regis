package battle_system.Characters;

import battle_system.Movelist.*;
import battle_system.TypeList;

public class Nova extends Fighter {

    public Nova() {
        super("Nova",
                TypeList.FIRE,
                0,
                0, // high atk
                0,
                0,
                0,
                0, // high speed
                new ScorchingScratch(),
                null,
                new Dodge());
    }

    //fire type
    @Override
    public void useMove(String move) {

    }
}
