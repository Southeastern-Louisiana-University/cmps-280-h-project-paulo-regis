package battle_system.Movelist;

import battle_system.Characters.Fighter;
import battle_system.Statuses.Infatuated;
import battle_system.TypeList;

public class GoodBoiPuppyEyes extends Move {
    public GoodBoiPuppyEyes() {
        super("Good Boi Puppy Eyes",
                TypeList.NORMAL,
                Category.STATUS,
                0,
                100,
                new Infatuated());
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
