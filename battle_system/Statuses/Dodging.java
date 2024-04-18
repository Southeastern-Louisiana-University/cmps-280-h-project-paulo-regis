package battle_system.Statuses;

import battle_system.Characters.Fighter;

public class Dodging extends Status {
    public Dodging() {
        super("Dodging",
                1);
    }

    @Override
    public void applyEffect(Fighter target) {
        target.setStatsMod(5, 100);
    }

    @Override
    public void endEffect(Fighter target) {
        target.setStatsMod(5, 0);
    }
}