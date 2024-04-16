package battle_system.Movelist;

import battle_system.TypeList;

public class Block extends Move {

    public Block(String name) {
        super(name,
                TypeList.NONE,
                Category.STATUS,
                0,
                100,
                "Block"); // best boy block regens hp sometimes?
    }
}
