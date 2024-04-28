package battle_system.Movelist;

import battle_system.Characters.Fighter;
import battle_system.Statuses.*;
import battle_system.TypeList;

public class ScorchingScratch extends Move {
    public ScorchingScratch() {
        super("Scorching Scratch",
                TypeList.FIRE,
                Category.PHYSICAL,
                100,
                100,
                new Burning(),
                false);
    }

    @Override
    public void useMove(Fighter attacker, Fighter target) {
        target.takeDamage(attacker, getPower(), getType(), getCategory());
        getInflicts().applyEffect(target);
    }
}
