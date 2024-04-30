package paulomon.Characters;

import paulomon.Movelist.*;
import paulomon.TypeList;

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
                new Regenerate(),
                new Block("Block"));
        setMoveTargets(boss, null, this, this);
    }
}
