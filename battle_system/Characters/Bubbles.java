package battle_system.Characters;

import battle_system.Movelist.*;
import battle_system.TypeList;

public class Bubbles extends Fighter {

    public Bubbles() {
        super("Bubbles",
                TypeList.WATER,
                0, // tanky
                0,
                0, // tanky
                0,
                0,
                0,
                null,
                new Regenerate(),
                new Block("Block"));
    }
    //water type
    @Override
    public void useMove(String move) {

    }
}
