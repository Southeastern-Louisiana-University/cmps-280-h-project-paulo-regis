package battle_system.Characters;

import battle_system.Movelist.*;
import battle_system.TypeList;

public class Bubbles extends Fighter {
    public Bubbles(Fighter boss) {
        super("Bubbles",
                "Axolotl",
                TypeList.WATER,
                TypeList.FIRE,
                500, // tanky
                50,
                200, // tanky
                100,
                175,
                50,
                new BubbleBazooka(),
                new Regenerate(), // TODO: Choose a target for this
                new Block("Block"));
        setMoveTargets(boss, null, this, this);
    }
}
