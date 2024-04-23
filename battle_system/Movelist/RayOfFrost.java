package battle_system.Movelist;

import battle_system.Characters.Fighter;
import battle_system.TypeList;

public class RayOfFrost extends Move {
    public RayOfFrost() {
        super("Ray of Frost",
                TypeList.ICE,
                Category.SPECIAL,
                150,
                100,
                null);
    }


    @Override
    public void useMove(Fighter target) {
        // deal damage
    }

    @Override
    public void useMove() {

    }
}
