package battle_system.Characters;

import battle_system.TypeList;
import battle_system.Movelist.*;

public class Pippin extends Fighter {

    public Pippin(Fighter boss) {
        super("Pippin",
                "Good Boi (doggo)",
                TypeList.GRASS,
                TypeList.WATER,
                0,
                0,
                0,
                0, // high spa
                0, // high spd
                0,
                new VineWhip(),
                new GoodBoiPuppyEyes(),
                new Block("Best Boy Block"));
        setMoveTargets(boss, boss, this, this);
    }
}
