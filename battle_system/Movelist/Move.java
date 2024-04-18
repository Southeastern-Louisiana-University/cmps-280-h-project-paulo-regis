package battle_system.Movelist;

import battle_system.Characters.Fighter;
import battle_system.Statuses.*;
import battle_system.TypeList;

public abstract class Move {
    private String name;
    private TypeList type;
    private Category category;
    private int power;
    private int accuracy; // hits if Math.ceiling(Math.random()*100)<accuracy (accuracy 0-100)
    private Status inflicts; // possible status
    // TODO: Implement priority for Blocking and Dodging

    private Fighter target;

    public enum Category {
        PHYSICAL,
        SPECIAL,
        STATUS
    }

    Move(String name,
         TypeList type,
         Category category,
         int power,
         int accuracy,
         Status inflicts) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.power = power;
        this.accuracy = accuracy;
        this.inflicts = inflicts;
    }

    Move(String name,
         TypeList type,
         Category category,
         int power,
         int accuracy) {
        this(name, type, category, power, accuracy, null);
    }

    public void setTarget(Fighter target) {this.target = target;}

    public String getName() {return name;}
    public TypeList getType() {return type;}
    public Category getCategory() {return category;}
    public int getPower() {return power;}
    public int getAccuracy() {return accuracy;}
    public Status getInflicts() {return inflicts;}
    public Fighter getTarget() {return target;}

    public void describeMove() {
        System.out.println("Move: " + name);
    }

    public abstract void useMove(Move move, Fighter target);
    public abstract void useMove(Move move);
}