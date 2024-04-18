package battle_system.Movelist;

import battle_system.Characters.Fighter;
import battle_system.Statuses.Blocking;
import battle_system.TypeList;

public class Block extends Move {

    public Block(String name) {
        super(name,
                TypeList.NONE,
                Category.STATUS,
                0,
                100,
                new Blocking()); // best boy block regens hp sometimes?
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
