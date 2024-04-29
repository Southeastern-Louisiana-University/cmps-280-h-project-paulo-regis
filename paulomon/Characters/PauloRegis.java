package paulomon.Characters;

import paulomon.Movelist.*;
import paulomon.TypeList;

public class PauloRegis extends Boss {

    public PauloRegis() {
        super("Paulo Regis",
                "Demigod of Eternal Winter",
                TypeList.ICE,
                TypeList.ROCK,
                600,
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
