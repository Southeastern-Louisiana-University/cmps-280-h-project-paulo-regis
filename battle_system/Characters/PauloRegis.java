package battle_system.Characters;

import battle_system.Movelist.*;
import battle_system.TypeList;

public class PauloRegis extends Fighter {

    public PauloRegis() {
        super("Paulo Regis",
                "Demigod of Eternal Winter",
                TypeList.ICE,
                TypeList.ROCK,
                300,
                0,
                200,
                0, // High def
                0,
                0,
                new RayOfFrost(),
                new Freeze(),
                new Block("Icy Shield"));
        setMoveTargets(null, null, this, this);
        // TODO: Random numbers (1-3) for move targets
    }

    public void dialogue() {

    }
}
