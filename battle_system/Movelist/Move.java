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
    private boolean chooseTarget;
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
         Status inflicts,
         boolean chooseTarget) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.power = power;
        this.accuracy = accuracy;
        this.inflicts = inflicts;
        this.chooseTarget = chooseTarget;
    }

    Move(String name,
         TypeList type,
         Category category,
         int power,
         int accuracy,
         boolean chooseTarget) {
        this(name, type, category, power, accuracy, null, chooseTarget);
    }

    public void setTarget(Fighter target) {this.target = target;}

    public String getName() {return name;}
    public TypeList getType() {return type;}
    public Category getCategory() {return category;}
    public int getPower() {return power;}
    public int getAccuracy() {return accuracy;}
    public Status getInflicts() {return inflicts;}
    public Fighter getTarget() {return target;}
    public boolean isChooseTarget() {return chooseTarget;}

    public void describeMove() {
        System.out.println("Move: " + name);
    }

    public void useMove(Fighter attacker, Fighter target) {
        if (category == Category.STATUS) {
            getInflicts().applyEffect(target);
        } else if (category == Category.PHYSICAL || category == Category.SPECIAL) {
            target.takeDamage(attacker, getPower(), getType(), getCategory());
        } else {
            System.out.println("Invalid status: not sure what to do with this move!");
        }
    }

    public void useMove(Fighter attacker) {
        useMove(attacker, getTarget());
    }

    public void useMove(Fighter attacker, Fighter[] targetList) {
        for (Fighter target : targetList) {
            useMove(attacker, target);
        }
    }

    @Override
    public String toString() {
        return name;
//        return "Move{" +
//                "name='" + name + '\'' +
//                ", type=" + type +
//                ", category=" + category +
//                ", power=" + power +
//                ", accuracy=" + accuracy +
//                ", inflicts=" + inflicts +
//                ", target=" + target +
//                '}';
    }
}