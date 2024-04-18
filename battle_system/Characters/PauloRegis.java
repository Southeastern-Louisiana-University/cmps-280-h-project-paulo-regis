package battle_system.Characters;

import battle_system.Movelist.*;
import battle_system.TypeList;

public class PauloRegis extends Fighter {

    //random type
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
                null,
                null,
                new Block("Icy Shield"));
    }

    public void dialogue() {

    }
}
