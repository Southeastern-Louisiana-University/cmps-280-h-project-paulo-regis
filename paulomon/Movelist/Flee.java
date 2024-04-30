package paulomon.Movelist;

import paulomon.Statuses.Fleeing;
import paulomon.TypeList;

public class Flee extends Move {

    public Flee() {
        super("Flee",
                "Does what it says on the box.",
                TypeList.NORMAL,
                Category.STATUS,
                0,
                0,
                new Fleeing(),
                false);
    }
}
