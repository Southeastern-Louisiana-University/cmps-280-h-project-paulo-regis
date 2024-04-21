package battle_system.Characters;

import battle_system.Movelist.*;
import battle_system.TypeList;

public class Nova extends Fighter {
    public Nova() {
        super("Nova",
                "Kitten",
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
        setMoveTargets(null, null, this, this); // TODO: find a way to target regis
    }
}