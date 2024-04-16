package battle_system.Characters;

import battle_system.TypeList;
import battle_system.Movelist.*;

public abstract class Fighter {

    private String name;
    private TypeList type;

    private int hp;
    private int atk;
    private int def;
    private int spA;
    private int spD;
    private int spe;

    private Move move1;
    private Move move2;

    private Move[] moveset = new Move[4];

    Fighter(String name,
            TypeList type,
            // Stats
            int hp,
            int atk,
            int def,
            int spA,
            int spD,
            int spe,
            // Moves
            Move move1,
            Move move2,
            Move move3) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spA = spA;
        this.spD = spD;
        this.spe = spe;
        this.moveset[0] = move1; // Offensive Move
        this.moveset[1] = move2; // Defensive Move
        this.moveset[2] = move3; // Dodge/Block
        this.moveset[3] = new Flee();
    }

    public String getName() {return name;}
    public TypeList getType() {return type;}
    public double getHp() {return hp;}
    public double getAtk() {return atk;}
    public double getDef() {return def;}
    public double getSpA() {return spA;}
    public double getSpD() {return spD;}
    public double getSpe() {return spe;}
    public double[] getStats() {return new double[] {hp, atk, def, spA, spD, spe};}
    public Move[] getMoveset() {return moveset;}
    public Move getMove(int index) {
        if (index < 1 || index > 4) {
            System.out.println("That's not the correct move choice for " + name + "! Please enter 1-4.");
            return null;
        } else {
            return moveset[index-1];
        }
    }

    public abstract void useMove(String move);
}
