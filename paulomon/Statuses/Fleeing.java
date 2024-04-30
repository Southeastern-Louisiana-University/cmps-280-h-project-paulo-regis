package paulomon.Statuses;

import paulomon.Characters.Fighter;
import paulomon.Characters.Sourceless;
import paulomon.Movelist.Move;
import paulomon.TypeList;

public class Fleeing extends Status {
    private static int damageToDoor = 0;

    public Fleeing() {
        super("Trying To Run",
                1,
                1);
    }

    @Override
    public void applyEffect(Fighter target) {
        if (damageToDoor < 10) {
            target.takeDamage(new Sourceless(), getDamageOverTime(), TypeList.NORMAL, Move.Category.STATUS);
            System.out.print(target.getName() + " slams their head on an icy wall as they try to flee, taking " + getDamageOverTime() + " damage. ");
        } else {
            System.out.println("The door has been opened, and " + target.getName() + " attempts to flee with the rest of their crew!");
        }
        damageToDoor++;

        if (damageToDoor < 10) {
            System.out.println("The exit is sealed shut!");
            if (damageToDoor > 5) {
                System.out.println("The ice door now has a slight crack in it...");
            }
        } else if (damageToDoor == 10) {
            System.out.println("\nThe door miraculously smashes open!");
        } else {
            // The door is already open
        }
    }

    @Override
    public void endEffect(Fighter target) {

    }

    public int getDamageToDoor() {return damageToDoor;}
    public boolean isDoorBroken() {return damageToDoor >= 10;}
}
