package paulomon.Statuses;

import paulomon.Characters.Fighter;
import paulomon.Characters.Sourceless;
import paulomon.Movelist.Move;
import paulomon.TypeList;

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
