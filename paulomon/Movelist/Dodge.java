package paulomon.Movelist;

import paulomon.Statuses.*;
import paulomon.TypeList;

public class Dodge extends Move {
    public Dodge() {
        super("Dodge",
                "Decreases the likelihood of getting hit.",
                TypeList.NORMAL,
                Category.STATUS,
                0,
                100,
                new Dodging(),
                false);
    }
}