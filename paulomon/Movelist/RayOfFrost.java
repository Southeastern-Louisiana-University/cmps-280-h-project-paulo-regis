package paulomon.Movelist;

import paulomon.TypeList;

public class RayOfFrost extends Move {
    public RayOfFrost() {
        super("Ray of Frost",
                "A powerful beam of frosty magic.",
                TypeList.ICE,
                Category.SPECIAL,
                150,
                100,
                null,
                false);
    }
}
