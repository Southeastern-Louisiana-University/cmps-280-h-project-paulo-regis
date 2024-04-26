package battle_system.Characters;

import battle_system.Movelist.*;
import battle_system.TypeList;

public class Nova extends Fighter {
    public Nova(Fighter boss) {
        super("Nova",
                "Kitten",
                TypeList.FIRE,
                TypeList.ICE,
                125,
                200, // high atk
                100,
                150,
                50,
                200, // high speed
                new ScorchingScratch(),
                new BlazingBreath(),
                new Dodge());
        setMoveTargets(boss, boss, this, this);
        // TODO: Resistance to Freeze?
    }
}