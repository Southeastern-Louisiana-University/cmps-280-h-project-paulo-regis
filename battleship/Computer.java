package battleship;

public class Computer extends Player{
    private boolean shipKnown = false;
    private String shipDiscoveryLocation = "NONE";
    private String shipLastLocation = "NONE";
    private String shipOrientation = "UNKNOWN";


    public Computer(String name){
        super(name);
    }

    public boolean hasKnownShip(){
        return shipKnown;
    }


    public String getKnownShipLocation(){
        if(shipKnown){
            return shipLastLocation;
        }
        return null;
    }

    public String getKnownShipDiscoveryLocation(){
        if(shipKnown){
            return shipDiscoveryLocation;
        }
        return null;
    }

    public void discoverShip(String location){
        shipKnown = true;
        shipDiscoveryLocation = location;
        shipLastLocation = location;
    }

    public void progressShip(String location){
        if(shipKnown){
            shipLastLocation = location;

            if(shipOrientation.equalsIgnoreCase("UNKNOWN")){
                int[] translation = GamePiece.findTranslation(shipDiscoveryLocation, shipLastLocation);
                assert translation != null;
                if(translation[0] != 0){
                    shipOrientation = "VERTICAL";
                } else if(translation[1] != 0){
                    shipOrientation = "HORIZONTAL";
                }
            }
        }
    }

    public void forgetShip(){
        shipKnown = false;
        shipOrientation = "UNKNOWN";
    }

    public void forgetShipOrientation(){
        shipOrientation = "UNKNOWN";
    }

    // At some point in development, I accidentally switched the X and Y axis of the grid. The code that displays the
    // grid shows it correctly, though, so I have chosen to just leave it as is and deal with the consequences
    // on my own.
    public int[][] getTranslations() {
        if(shipOrientation.equalsIgnoreCase("UNKNOWN")) { // Hit a random adjacent square
            return new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // Translation components that point to adjacent squares
        } else if (shipOrientation.equalsIgnoreCase("VERTICAL")) {
            return new int[][]{{1, 0}, {-1, 0}};
        } else {
            return new int[][]{{0, 1}, {0, -1}};
        }
    }

    public final String[] shipLostDialogue = {
            "Dr. Paulo's smirks a little, no sign of worry at all.",
            "Dr. Paulo chooses not to react. It's hard to get a read on what he's thinking.",
            "\"You know, it's been a while since I've been able to enjoy a simple game like this.\"\nYou can feel the tension in the air thicken.",
            "A frown starts to form on Dr. Paulo's face.\n\"You may be close to winning, but don't get cocky now.\"",
            "\"Good game, good game,\" Dr. Paulo tells you, but you can see it isn't genuine.\nWhile thinking of what to say, Dr. Paulo seems to dissolve into the shadows.\nYou might be seeing things."
    };
}
