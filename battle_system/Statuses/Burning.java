package battle_system.Statuses;

import battle_system.Characters.Fighter;

public class Burning extends Status {
    public Burning() {
        super("Burning",
                3,
                10);
    }

    @Override
    public void applyEffect(Fighter target) {
        target.takeDamage(getDamageOverTime());
    }

    @Override
    public void endEffect(Fighter target) {

    }
}
