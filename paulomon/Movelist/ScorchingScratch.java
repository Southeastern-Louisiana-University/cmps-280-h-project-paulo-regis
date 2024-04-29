package paulomon.Movelist;

import paulomon.Characters.Fighter;
import paulomon.Statuses.*;
import paulomon.TypeList;

public class ScorchingScratch extends Move {
    public ScorchingScratch() {
        super("Scorching Scratch",
                "A near-rabid claw sheathed in infernal power.",
                TypeList.FIRE,
                Category.PHYSICAL,
                100,
                100,
                new Burning(),
                false);
    }

    @Override
    public void useMove(Fighter attacker, Fighter target) {
        target.takeDamage(attacker, getPower(), getType(), getCategory());
        getInflicts().applyEffect(target);
    }
}
