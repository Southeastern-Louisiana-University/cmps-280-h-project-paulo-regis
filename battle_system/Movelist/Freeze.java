package battle_system.Movelist;

import battle_system.Characters.Fighter;
import battle_system.Statuses.*;
import battle_system.TypeList;

public class Freeze extends Move {

    public Freeze() {
        super("Freeze",
                TypeList.ICE,
                Category.STATUS,
                25,
                50,
                new Frozen());
    }

    @Override
    public void useMove(Fighter target) {
        getInflicts().applyEffect(target);
    }

    @Override
    public void useMove() {
        getInflicts().applyEffect(getTarget());
    }
}
