package battle_system.Characters;

import battle_system.Movelist.*;
import battle_system.TypeList;

public class PauloRegis extends Boss {

    public PauloRegis() {
        super("Paulo Regis",
                "Demigod of Eternal Winter",
                TypeList.ICE,
                TypeList.ROCK,
                300,
                50,
                200,  // High def
                125,
                100,
                100,
                new RayOfFrost(),
                new Freeze(),
                new Block("Icy Shield"));
        setMoveTargets(null, null, this, this);
    }
}
