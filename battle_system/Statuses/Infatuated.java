package battle_system.Statuses;

import battle_system.Characters.Fighter;

public class Infatuated extends Status {
    public Infatuated() {
        super("Infatuated",
                2,
                0);
    }

    @Override
    public void applyEffect(Fighter target) {
        target.modifyStatsMod(3, -75);
        target.modifyStatsMod(5, -75);
    }

    @Override
    public void endEffect(Fighter target) {
        target.modifyStatsMod(3, 75);
        target.modifyStatsMod(5, 75);
    }
}
