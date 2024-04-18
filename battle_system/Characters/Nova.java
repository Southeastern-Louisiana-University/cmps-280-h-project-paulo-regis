package battle_system.Characters;

import battle_system.Movelist.*;
import battle_system.TypeList;

public class Nova extends Fighter {
    public Nova() {
        super("Nova",
                TypeList.FIRE,
                125,
                200, // high atk
                50,
                150,
                100,
                200, // high speed
                new ScorchingScratch(),
                null,
                new Dodge());
        getMove(1).setTarget(null); // TODO: find a way to target regis
        getMove(2).setTarget(null);
        getMove(3).setTarget(this);
        getMove(4).setTarget(this);
    }
}