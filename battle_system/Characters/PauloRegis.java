package battle_system.Characters;

import battle_system.Movelist.*;
import battle_system.TypeList;

public class PauloRegis extends Fighter {

    public PauloRegis() {
        super("Paulo Regis",
                "Demigod of Eternal Winter",
                TypeList.ICE,
                300,
                0,
                0,
                0,
                0,
                0,
                new RayOfFrost(),
                new Freeze(),
                new Block("Icy Shield"));
        setMoveTargets(null, null, this, this);
    }

    public void dialogue() {

    }
}
