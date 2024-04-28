package battle_system.Statuses;

import battle_system.Characters.Fighter;

public class Dodging extends Status {
    public Dodging() {
        super("Dodging",
                1,
                0);
    }

    @Override
    public void applyEffect(Fighter target) {
        System.out.println(target.getName() + " is dodging! Their speed increases!");
        target.modifyStatsMod(5, 100);
    }

    @Override
    public void endEffect(Fighter target) {
        target.modifyStatsMod(5, -100);
    }
}