package battle_system.Movelist;

import battle_system.Characters.Fighter;
import battle_system.TypeList;

public class BubbleBazooka extends Move {

    public BubbleBazooka() {
        super("Bubble Bazooka",
                TypeList.WATER,
                Category.SPECIAL,
                50,
                100,
                null);
    }

    @Override
    public void useMove(Move move, Fighter target) {
        // deal damage
    }

    @Override
    public void useMove(Move move) {

    }
}