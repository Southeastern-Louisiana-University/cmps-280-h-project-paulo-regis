package battle_system.Movelist;

import battle_system.Characters.Fighter;
import battle_system.Statuses.*;
import battle_system.TypeList;

public class Dodge extends Move {
    public Dodge() {
        super("Dodge",
                TypeList.NONE,
                Category.STATUS,
                0,
                100,
                new Dodging());
    }

    @Override
    public void useMove(Move move, Fighter target) {
        getInflicts().applyEffect(target);
    }

    @Override
    public void useMove(Move move) {
        getInflicts().applyEffect(getTarget());
    }
}