package battle_system.Movelist;

import battle_system.Characters.Fighter;
import battle_system.Statuses.*;
import battle_system.TypeList;

public class Block extends Move {

    public Block(String name) {
        super(name,
                TypeList.NORMAL,
                Category.STATUS,
                0,
                100,
                new Blocking(),
                false); // best boy block regens hp sometimes?
    }
}
