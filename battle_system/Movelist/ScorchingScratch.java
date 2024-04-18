package battle_system.Movelist;

import battle_system.Characters.Fighter;
import battle_system.Statuses.Burning;
import battle_system.TypeList;

public class ScorchingScratch extends Move {

    public ScorchingScratch() {
        super("Scorching Scratch",
                TypeList.FIRE,
                Category.PHYSICAL,
                100,
                100,
                new Burning());
    }

    @Override
    public void useMove(Move move, Fighter target) {
        // Deal damage
    }

    @Override
    public void useMove(Move move) {

    }
}
