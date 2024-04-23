package battle_system.Statuses;

import battle_system.Characters.Fighter;

public class Frozen extends Status {
    public Frozen() {
        super("Frozen",
                3,
                0);
    }


    @Override
    public void applyEffect(Fighter target) {
        System.out.println(target.getName() + " is frozen and unable to move!");
        // TODO: Pass turn
    }

    @Override
    public void endEffect(Fighter target) {

    }
}
