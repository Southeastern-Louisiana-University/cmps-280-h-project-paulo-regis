package paulomon.Movelist;

import paulomon.Statuses.*;
import paulomon.TypeList;

public class Block extends Move {

    public Block(String name) {
        super(name,
                "Braces for and reduces incoming damage.",
                TypeList.NORMAL,
                Category.STATUS,
                0,
                100,
                new Blocking(),
                false); // best boy block regens hp sometimes?
    }
}
