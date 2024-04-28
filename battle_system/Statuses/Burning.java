package battle_system.Statuses;

import battle_system.Characters.Fighter;
import battle_system.Characters.Sourceless;
import battle_system.Movelist.Move;
import battle_system.TypeList;

public class Burning extends Status {
    public Burning() {
        super("Burning",
                3,
                20);
    }

    @Override
    public void applyEffect(Fighter target) {
        System.out.println(target.getName() + " is burning!");
        target.takeDamage(new Sourceless(), getDamageOverTime(), TypeList.FIRE, Move.Category.STATUS);
    }

    @Override
    public void endEffect(Fighter target) {

    }
}
