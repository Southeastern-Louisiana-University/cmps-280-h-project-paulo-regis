package battle_system.Characters;

import battle_system.Movelist.Block;
import battle_system.Movelist.Freeze;
import battle_system.Movelist.Move;
import battle_system.Movelist.RayOfFrost;
import battle_system.TypeList;

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
