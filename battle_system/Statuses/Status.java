package battle_system.Statuses;

import battle_system.Characters.Fighter;

public abstract class Status {
    private String name;
    private int duration; // amount of rounds; increments at the start of the user's next turn
    // -1 duration lasts forever
    private Fighter target;
    private int damageOverTime;

    Status(String name,
           int duration,
           int damageOverTime) {
        this.name = name;
        this.duration = duration;
        this.damageOverTime = damageOverTime;
    }

    public void decrementDuration() {
        if (duration > 0) {duration--;}
        if (duration == 0) {endEffect(target);}
    }

    public String getName() {return name;}
    public int getDuration() {return duration;}
    public Fighter getTarget() {return target;}

    public abstract void applyEffect(Fighter target);
    public abstract void endEffect(Fighter target);

}