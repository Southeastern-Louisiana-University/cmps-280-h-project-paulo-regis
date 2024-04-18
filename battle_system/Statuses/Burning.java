package battle_system.Statuses;

import battle_system.Characters.Fighter;

public class Burning extends Status {
    public Burning() {
        super("Burning",
                3);
    }

    @Override
    public void applyEffect(Fighter target) {
        // deal DoT
    }

    @Override
    public void endEffect(Fighter target) {

    }
}
