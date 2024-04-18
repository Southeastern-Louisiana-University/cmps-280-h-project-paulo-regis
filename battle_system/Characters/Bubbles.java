package battle_system.Characters;

import battle_system.Movelist.*;
import battle_system.TypeList;

public class Bubbles extends Fighter {

    public Bubbles() {
        super("Bubbles",
                "Axolotl",
                TypeList.WATER,
                0, // tanky
                0,
                0, // tanky
                0,
                0,
                0,
                new BubbleBazooka(),
                new Regenerate(),
                new Block("Block"));
    }
}
