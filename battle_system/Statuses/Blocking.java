package battle_system.Statuses;

import battle_system.Characters.Fighter;

public class Blocking extends Status {
    public Blocking() {
        super("Blocking",
                1,
                0);
    }

    @Override
    public void applyEffect(Fighter target) {
        target.modifyStatsMod(3, 100);
    }

    @Override
    public void endEffect(Fighter target) {
        target.modifyStatsMod(3, -100);
    }
}
