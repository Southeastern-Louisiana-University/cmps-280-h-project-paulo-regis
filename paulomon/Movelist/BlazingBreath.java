package paulomon.Movelist;

import paulomon.Statuses.*;
import paulomon.TypeList;

public class BlazingBreath extends Move {
    public BlazingBreath() {
        super("Blazing Breath",
                "A fiery blaze sourced from the kitten's mouth.",
                TypeList.FIRE,
                Category.SPECIAL,
                100,
                100,
                new Burning(),
                false);
    }
}
