package battle_system.Statuses;

import battle_system.Characters.Fighter;
import battle_system.Characters.Sourceless;
import battle_system.Movelist.Move;
import battle_system.TypeList;

public class Fleeing extends Status {
    private int damageToDoor = 0;

    public Fleeing() {
        super("Trying To Run",
                1,
                1);
    }

    @Override
    public void applyEffect(Fighter target) {
        target.takeDamage(new Sourceless(), getDamageOverTime(), TypeList.NORMAL, Move.Category.STATUS);
        System.out.print(target.getName() + " slams their head on an icy wall as they try to flee, taking " + getDamageOverTime() + " damage. ");
        damageToDoor++;

        if (damageToDoor < 10) {
            System.out.println("The exit is sealed shut!");
            if (damageToDoor > 5) {
                System.out.println("The ice door now has a slight crack in it...");
            }
        } else {
            System.out.println("\nThe door miraculously smashes open!");
            // TODO: Escape!
        }
    }

    @Override
    public void endEffect(Fighter target) {

    }

    public int getDamageToDoor() {return damageToDoor;}
    public boolean isDoorBroken() {return damageToDoor >= 10;}
}
