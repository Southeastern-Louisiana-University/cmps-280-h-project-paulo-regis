package battle_system.Characters;

import battle_system.TypeList;
import battle_system.Movelist.*;

public abstract class Fighter {

    private String name;
    private TypeList type;

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

    // Moves
//    private Move move1;
//    private Move move2;
//    private Move move3;
//    private Move move4;
    private Move[] moveset = new Move[4];

    Fighter(String name,
            TypeList type,
            // Stats
            int baseHp,
            int baseAtk,
            int baseDef,
            int baseSpA,
            int baseSpD,
            int baseSpe,
            // Moves
            Move move1,
            Move move2,
            Move move3) {
        this.name = name;
        this.type = type;
        setStatsBase(baseHp,
                baseAtk,
                baseDef,
                baseSpA,
                baseSpD,
                baseSpe);
        this.moveset[0] = move1; // Offensive Move
        this.moveset[1] = move2; // Defensive Move
        this.moveset[2] = move3; // Dodge/Block
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
        statsBase[1] = baseAtk;
        statsBase[2] = baseDef;
        statsBase[3] = baseSpA;
        statsBase[4] = baseSpD;
        statsBase[5] = baseSpe;
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

    public void setMove(int index, Move move) {
        if (verifyChoice(index, 1, 4, "setting a move")) {
            moveset[index-1] = move;
        }
    }

    public String getName() {return name;}
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
    public Move[] getMoveset() {return moveset;}
    public Move getMove(int index) {
        if (verifyChoice(index, 1, 4, "getting a move")) {
            return moveset[index-1];
        } else {return null;}
    }

    private boolean verifyChoice(int index, int start, int end, String purpose) {
        if (index < start || index > end) {
            System.out.println("That's not a correct choice for " + name + "'s " + purpose + "! Please enter " + start + "-" + end +".");
            return false;
        } else {return true;}
    }

    public void useMove(Move move, Fighter target) {
        Move.Category category = move.getCategory();
        int toHit = (int) Math.ceil(Math.random()*100);
        if (toHit > move.getAccuracy()) {
            move.useMove(move, target);
        } else {
            System.out.println("The move missed!");
        }
    }
}