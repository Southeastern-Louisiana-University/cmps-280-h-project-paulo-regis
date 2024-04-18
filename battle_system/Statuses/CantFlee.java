package battle_system.Statuses;

import battle_system.Characters.Fighter;

public class CantFlee extends Status {
    public CantFlee() {
        super("You can't flee from a trainer battle!",
                1,
                1);
    }

    @Override
    public void applyEffect(Fighter target) {
        // haha funny?
        // deal 1 damage to target for that round as they smack their face on the icy wall
    }

    @Override
    public void endEffect(Fighter target) {

    }
}
