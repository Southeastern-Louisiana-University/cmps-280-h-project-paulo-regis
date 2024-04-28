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
        System.out.println(target.getName() + " is now blocking! Their defense and special defense increase!");
        target.modifyStatsMod(3, 100);
        target.modifyStatsMod(5, 100);
    }

    @Override
    public void endEffect(Fighter target) {
        target.modifyStatsMod(3, -100);
    }
}
