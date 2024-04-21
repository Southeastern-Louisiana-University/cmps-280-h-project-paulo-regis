package battle_system.Statuses;

import battle_system.Characters.Fighter;

public class CantFlee extends Status {
    static int damageToDoor = 0;
    public CantFlee() {
        super("You can't flee from a trainer battle!",
                1,
                1);
    }

    @Override
    public void applyEffect(Fighter target) {
        target.takeDamage(getDamageOverTime());
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
}
