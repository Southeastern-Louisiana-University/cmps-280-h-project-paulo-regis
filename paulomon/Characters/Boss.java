package paulomon.Characters;

import paulomon.Movelist.Move;
import paulomon.TypeList;

public abstract class Boss extends Fighter {

    Boss(String name,
         String animal,
         TypeList type,
         TypeList resistance,
         int baseHp,
         int baseAtk,
         int baseDef,
         int baseSpA,
         int baseSpD,
         int baseSpe,
         Move move0,
         Move move1,
         Move move2) {
        super(name, animal, type, resistance, baseHp, baseAtk, baseDef, baseSpA, baseSpD, baseSpe, move0, move1, move2);
    }

    public void bossAI() {

    }

    public void decideMove() {

    }

}
