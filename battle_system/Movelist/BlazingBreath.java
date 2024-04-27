package battle_system.Movelist;

import battle_system.Characters.Fighter;
import battle_system.Statuses.*;
import battle_system.TypeList;

public class BlazingBreath extends Move {
    public BlazingBreath() {
        super("Blazing Breath",
                TypeList.FIRE,
                Category.SPECIAL,
                100,
                100,
                new Burning());
    }
}
