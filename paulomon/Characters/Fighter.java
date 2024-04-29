package paulomon.Characters;

import paulomon.TypeList;
import paulomon.Movelist.*;

public abstract class Fighter implements Comparable<Fighter> {

    private String name;
    private String animal;
    private TypeList type;
    private TypeList resistance;

    // Base stats
//    private int baseHp;  // Endurance
//    private int baseAtk; // Contact attacks (increases outgoing damage)
//    private int baseDef; // Contact defenses (reduces incoming damage)
//    private int baseSpA; // Ranged attacks (increases outgoing special damage)
//    private int baseSpD; // Ranged defenses (reduces incoming special damage)
//    private int baseSpe; // Turn order and also evasiveness
    private int[] statsBase = new int[6];

    // Stat modifiers
//    private int modHp;
//    private int modAtk;
//    private int modDef;
//    private int modSpA;
//    private int modSpD;
//    private int modSpe;
    private int[] statsMod = new int[6];

    // Actual stats
//    private int hp;
//    private int atk;
//    private int def;
//    private int spA;
//    private int spD;
//    private int spe;
    private int[] statsActual = new int[6];

    private int hpCurrent;

    // Moves
//    private Move move1;
//    private Move move2;
//    private Move move3;
//    private Move move4;
    private Move[] moveset = new Move[4];

    Fighter(String name,
            String animal,
            TypeList type,
            TypeList resistance,
            // Stats
            int baseHp,
            int baseAtk,
            int baseDef,
            int baseSpA,
            int baseSpD,
            int baseSpe,
            // Moves
            Move move0,
            Move move1,
            Move move2) {
        this.name = name;
        this.animal = animal;
        this.type = type;
        setStatsBase(baseHp,
                baseAtk,
                baseDef,
                baseSpA,
                baseSpD,
                baseSpe);
        this.moveset[0] = move0; // Offensive Move
        this.moveset[1] = move1; // Defensive Move
        this.moveset[2] = move2; // Dodge/Block
        this.moveset[3] = new Flee();
    }

    private void setStatsBase(int baseHp,
                              int baseAtk,
                              int baseDef,
                              int baseSpA,
                              int baseSpD,
                              int baseSpe) {
//        this.baseHp = baseHp;
//        this.baseAtk = baseAtk;
//        this.baseDef = baseDef;
//        this.baseSpA = baseSpA;
//        this.baseSpD = baseSpD;
//        this.baseSpe = baseSpe;
        statsBase[0] = baseHp;
        hpCurrent = baseHp;
        statsBase[1] = baseAtk;
        statsBase[2] = baseDef;
        statsBase[3] = baseSpA;
        statsBase[4] = baseSpD;
        statsBase[5] = baseSpe;
        updateStats();
    }

    // TODO: Add documentation to help remember what index goes to what stat
    public void setStatsMod(int index, int value) {
        if (index < 0 || index > 5) {
            System.out.println("'"+index+"' is not a valid stat mod to set!");
        } else {
            statsMod[index] = value;
            updateStats();
        }
    }

    // TODO: Add documentation to help remember what index goes to what stat
    public void modifyStatsMod(int index, int value) {
        if (index < 0 || index > 5) {
            System.out.println("'"+index+"' is not a valid stat mod to modify!");
        } else {
            statsMod[index] += value;
            updateStats();
        }
    }

    private void updateStats() {
        for (int i = 0; i < statsActual.length; i++) {
            statsActual[i] = statsBase[i] + statsMod[i];
        }
    }

    private void verifyHp() {
        if (hpCurrent > getHpMax()) {
            hpCurrent = getHpMax();
        } else if (isFainted()) {
            System.out.println(name + " has fainted and can no longer fight!");
            hpCurrent = 0;
        }
    }

    public void modifyHp(int hp) {
        if (hpCurrent <= 0) {System.out.println(name + " has been revived! (" + hpCurrent+"/"+getHpMax());}
        hpCurrent += hp;
        verifyHp();
    }

    public void takeDamage(Fighter source, int damage, TypeList type, Move.Category category) {
        int divider = 1;
        int attack = 0;
        int defense = 0;

        if (type == getType()) {divider *= 2;}
        if (category == Move.Category.PHYSICAL) {
            attack = source.getStatsActualSingle(2);
            defense = getStatsActualSingle(3);
        } else if (category == Move.Category.SPECIAL) {
            attack = source.getStatsActualSingle(4);
            defense = getStatsActualSingle(5);
        }

        damage += attack/5;
        damage -= defense/5;
        System.out.print(name + " takes " + damage + " damage!");
        hpCurrent -= damage/divider;
        verifyHp();
        System.out.println(" (" + getHpCurrent() + "/" + getHpMax() + ")");
    }

    public boolean isFainted() {return (getHpCurrent() <= 0);}

    public void setMove(int index, Move move) {
        if (verifyChoice(index, 1, 4, "setting a move")) {
            moveset[index-1] = move;
        }
    }

    public void setMoveTargets(Fighter target1, Fighter target2, Fighter target3, Fighter target4) {
        moveset[0].setTarget(target1);
        moveset[1].setTarget(target2);
        moveset[2].setTarget(target3);
        moveset[3].setTarget(target4);
    }

    public String getName() {return name;}
    public String getAnimal() {return animal;}
    public TypeList getType() {return type;}

    private int getStat(int index, int[] statArr) {
        if (verifyChoice(index, 0, 5, "base stat")) {
            return statArr[index];
        } else {return 0;}
    }
    // TODO: Add documentation to help remember what index goes to what stat
    public int getStatsBaseSingle(int index) {return getStat(index, statsBase);}
    public int[] getStatsBase() {return statsBase;}
    public int getStatsModSingle(int index) {return getStat(index, statsMod);}
    public int[] getStatsMod() {return statsMod;}
    public int getStatsActualSingle(int index) {return getStat(index, statsActual);}
    public int[] getStatsActual() {return statsActual;}
    public int getHpCurrent() {return hpCurrent;}
    public int getHpMax() {return getStatsActualSingle(0);}
    public Move[] getMoveset() {return moveset;}
    public Move getMove(int index) {
        if (verifyChoice(index, 0, 3, "getting a move")) {
            return moveset[index];
        } else {return null;}
    }

    private boolean verifyChoice(int index, int start, int end, String purpose) {
        if (index < start || index > end) {
            System.out.println("That's not a correct choice for " + name + "'s " + purpose + "! Please enter " + start + "-" + end +".");
            return false;
        } else {return true;}
    }

    public void useMove(Move move, Fighter target) {
        System.out.println(name + " uses " + move.getName() + " on " + target + "!");
        Move.Category category = move.getCategory();
        int toHit = (int) Math.ceil(Math.random()*100);

        if (category != Move.Category.STATUS) {
            if (toHit < (move.getAccuracy() - (target.getStatsActualSingle(5) / 5))) { // tohit < (accuracy - (speed / 5))
                move.useMove(this, target);
            } else {
                System.out.println(name + "'s move missed!");
            }
        } else {
            move.useMove(this, target);
        }
    }

    public void useMove(Move move) {
        useMove(move, move.getTarget());
    }

    public void useMove(int moveIndex, Fighter target) {
        useMove(getMove(moveIndex), target);
    }

    public void useMove(int moveIndex) {
        useMove(moveIndex, getMove(moveIndex).getTarget());
    }

    public void useMoveAoE(Move move, Fighter[] targetList) {
        System.out.println(name + " uses " + move.getName() + " on everyone!!");
        move.useMove(this, targetList);
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public int compareTo(Fighter o) {
        if (o.getName() == name) {return 0;}
        else {return -1;}
    }
}