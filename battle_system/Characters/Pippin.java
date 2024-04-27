package battle_system.Characters;

import battle_system.TypeList;
import battle_system.Movelist.*;

public class Pippin extends Fighter {

    public Pippin(Fighter boss) {
        super("Pippin",
                "Good Boi (doggo)",
                TypeList.GRASS,
                TypeList.WATER,
                300,
                25,
                100,
                200, // high spa
                200, // high spd
                150,
                new VineWhip(),
                new GoodBoiPuppyEyes(),
                new Block("Best Boy Block"));
        setMoveTargets(boss, boss, this, this);
    }
}
