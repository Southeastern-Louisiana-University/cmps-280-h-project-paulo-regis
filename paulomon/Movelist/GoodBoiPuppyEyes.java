package paulomon.Movelist;

import paulomon.Statuses.Infatuated;
import paulomon.TypeList;

public class GoodBoiPuppyEyes extends Move {
    public GoodBoiPuppyEyes() {
        super("Good Boi Puppy Eyes",
                "An adorable gaze that lowers the enemy's guard.",
                TypeList.NORMAL,
                Category.STATUS,
                0,
                100,
                new Infatuated(),
                false);
    }
}
