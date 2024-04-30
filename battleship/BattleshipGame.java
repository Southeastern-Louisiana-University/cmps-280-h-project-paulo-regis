package battleship;
// ----------------------------------------------
//              JAVA BATTLESHIP
// ----------------------------------------------
//  A faithful recreation of the Battleship board game,
//  playable entirely within an IDE's output log.
//
//  Written by Wren Caillouet


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BattleshipGame {
    static Scanner input = new Scanner(System.in);

    // QOL information trackers to display information to the player on their turn
    static int turnCount = 0;
    static String lastSquare;
    static boolean shipStruck;
    static boolean shipSank;
    static int cpuShipsSank = 0;

    // These are the lengths of the 5 ship pieces that come with a physical battleship game.
    private final static int[] pieces = {5, 4, 3, 3, 2};

    enum states {
        START,
        P1SETUP,
        P2SETUP,
        P1TURN,
        P2TURN,
        END
    }
    public static void playBattleship() {
        states gameState = states.START;
        boolean gameActive = true;

        Player player1 = new Player();
        Computer cpuPlayer = new Computer("Dr. Paulo");
        Player winner = null;

        // Big ol' do-while loop. One iteration of this game loop should correspond to one in-game step or turn.
        // The value of `gameState` should change at some point over every iteration.
        do{
            switch (gameState){
                case START -> {
                    String name;
                    System.out.print("Tell me your name... ");
                    name = input.nextLine().trim();
                    player1.setName(name);
                    gameState = states.P1SETUP;
                }

                case P1SETUP -> {
                    setupBoard(player1);
                    gameState = states.P2SETUP;
                }

                case P2SETUP -> {
                    automaticSetupBoard(cpuPlayer);
                    gameState = states.P1TURN;
                }

                case P1TURN -> {
                    takeTurn(player1, cpuPlayer);
                    if(cpuPlayer.checkLoss()){
                        winner = player1;
                        gameState = states.END;
                        continue;
                    }
                    gameState = states.P2TURN;
                }

                case P2TURN -> {
                    automaticTakeTurn(cpuPlayer, player1);
                    if(player1.checkLoss()){
                        winner = cpuPlayer;
                        gameState = states.END;
                        continue;
                    }
                    gameState = states.P1TURN;
                }

                case END -> {
                    System.out.println("\n\n----------- GAME OVER -----------");
                    System.out.println(winner.getName() + " sunk all battleships and won!");
                    System.out.println();
                    System.out.println(player1.getBoard().generateGameOverView(cpuPlayer.getBoard()));

                    gameActive = false;

                    if (cpuPlayer == winner) {
                        System.out.println("\t\t\t\t      ||||");
                        System.out.println("\t\t\t\t      |||||");
                        System.out.println("\t\t\t\t      ||||||");
                        System.out.println("\t\t\t\t      ||||||");
                        System.out.println("\t\t\t\t      |||||||");
                        System.out.println("\t\t\t\t      |||||||");
                        System.out.println("\t\t   ////\\\\\\\\   |||||||   ////\\\\\\\\   ////\\\\\\\\");
                        System.out.println("\t\t   ||||||||   ||||||||  ||||||||   ||||||||");
                        System.out.println("||||||\\\\   ||||||||   ||||||||  ||||||||   ||||||||");
                        System.out.println("|||||\\\\\\\\  ||||||||   ||||||||  ||||||||   ||||||||");
                        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||");
                        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||");
                        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||");
                        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||");
                        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||");
                        System.out.println("\t\t|||||||||||||||||||||||||||||||||||||||||");
                        System.out.println("\t\t|||||||||||||||||||||||||||||||||||||||||");
                        System.out.println("\t\t|||||||||||||||||||||||||||||||||||||||||");
                        System.out.println("\t\t||||||||||||||||||||||||||||||||||||||");
                        System.out.println("GAME OVER");
                        System.exit(0);
                    }
                }
            }
        } while (gameActive);
    }

    private static void automaticSetupBoard(Player player) {
        Board board = player.getBoard();

        for (int piece : pieces) {
            boolean horizontal;
            String location;

            do{
                boolean locationUndecided = true;

                // --------------- Decide orientation -----------------
                int coinFlip = (int)(Math.random()*2);
                horizontal = coinFlip < 1;

                // --------------- Decide location -----------------
                // Iterates until a valid input is made.
                do{
                    int x = (int)(Math.random() * board.grid.length);
                    int y = (int)(Math.random() * board.grid.length);
                    location = GamePiece.coordinateToString(x, y);

                    if(board.isValidCoordinateSilent(location)){
                        locationUndecided = false;
                    }
                } while (locationUndecided);

            } while (!board.addShip(piece, location, horizontal, false));
        }
    }

    // Should only be called once per player in the setup phases.
    // Takes a player object and walks a human player through the process of populating that player
    // object's board with ship pieces.
    private static void setupBoard(Player player) {
        System.out.println(player.getName() + ", press enter to begin setting up your board.");
        input.nextLine();

        for (int piece : pieces) {
            System.out.println("Next piece: " + piece + " long ship.");
            manualPlaceShip(player, piece);
        }

        System.out.println("Final board: ");
        System.out.println(player.getBoard().boardToString(false));

        // Show the results until the player gives the OK to hide them.
        System.out.print("Press enter to finish setup.");
        input.nextLine();
    }

    // Takes a player object and a piece length, and walks a human player through the process
    // of placing the piece on the player object's board. Cool stuff.
    private static void manualPlaceShip(Player player, int piece){
        Board board = player.getBoard();

        boolean horizontal = false;
        String location;

        do{
            boolean orientationUndecided = true;
            boolean locationUndecided = true;

            System.out.println(board.boardToString(false));

            // --------------- Decide orientation -----------------
            // Iterates until a valid input is made.
            do{
                String str;
                System.out.println("Should your " + piece + " long ship be vertical or horizontal?");
                System.out.print("Input V for vertical, or H for horizontal: ");
                str = input.nextLine().trim();

                if(str.equalsIgnoreCase("V")){
                    orientationUndecided = false;
                } else if(str.equalsIgnoreCase("H")){
                    horizontal = true;
                    orientationUndecided = false;
                } else {
                    System.out.println("Please enter a valid input.");
                }

                System.out.println();
            } while (orientationUndecided);

            // --------------- Decide location -----------------
            // Iterates until a valid input is made.
            do{
                System.out.println("Where should the " + (horizontal ? "left" : "top") +" square of the ship be placed?");
                System.out.print("Enter a coordinate: ");
                location = input.nextLine().trim();

                if(board.isValidCoordinate(location)){
                    locationUndecided = false;
                }

                System.out.println();
            } while (locationUndecided);

        } while (!board.addShip(piece, location, horizontal, true));
    }

    private static void takeTurn(Player player, Computer opponent) {
        turnCount++;
        String target;
        boolean targetUndecided = true;
        Board board = player.getBoard();
        Board opponentBoard = opponent.getBoard();

        System.out.println();
        System.out.println("---------------------------");
        System.out.println(player.getName() + "'s turn!");
        System.out.println("---------------------------");
        // Show the board
        System.out.println(board.generateView(opponentBoard));

        // Display data about the last turn for the current player.
        if(turnCount > 1){ // At least one turn needs to occur to be able to display data
            System.out.println(opponent.getName() + " struck square " + lastSquare + ".");
            System.out.println("It was a " + (shipStruck ? "hit!" : "miss."));
            if(shipSank){
                System.out.println(opponent.getName() + " sunk your battleship...");
            }
            System.out.println();
        }

        // Main turn loop - iterates until a valid move is made.
        do {
            System.out.print("Enter a coordinate on your opponent's board to strike: ");
            target = input.nextLine().trim();
            if(opponentBoard.isValidCoordinate(target)){
                if(opponentBoard.strikeBoard(target)){
                    // A successful strike was made on the board. Break out of the turn loop.
                    targetUndecided = false;

                    // Collect data about the square that was hit to display to the next player.
                    lastSquare = target.toUpperCase();
                    Cell c = opponentBoard.getCell(lastSquare);

                    shipStruck = false;
                    shipSank = false;

                    if(c.hasShip()){
                        shipStruck = true;
                        if(c.getShip().getSurvivingUnits() <= 0){
                            shipSank = true;
                        }
                    }
                }
            }
        } while (targetUndecided);

        pause(750);

        if(shipSank){
            System.out.println();
            System.out.println(opponent.shipLostDialogue[cpuShipsSank]);
            cpuShipsSank++;
            pause(1500 * cpuShipsSank);
        }
    }

    private static void automaticTakeTurn(Computer cpu, Player opponent) {
        turnCount++;

        String target = "NONE";
        boolean noValidTarget = true;
        int iterations = 0;

        Board opponentBoard = opponent.getBoard();
        ArrayList<String> checkeredTargets = opponentBoard.checkerBoard;
        ArrayList<String> validTargets = opponentBoard.unhitSquares;

        System.out.println();
        System.out.println("---------------------------");
        System.out.println(cpu.getName() + "'s turn!");
        System.out.println("---------------------------");

        pause(1000);

        do { // DECIDE WHICH SQUARE TO ANNIHILATE WITH UNENDING WRATH
            if (cpu.hasKnownShip()) { // Computer has previously struck a ship before - use SMART LOGIC :D
                if(++iterations > 4){
                    System.out.println(cpu.getName() + " experiences analysis paralysis!");
                    cpu.forgetShip();
                }

                int[][] translations = cpu.getTranslations();
                Stack<String> adjacentSquares = new Stack<>();
                String shipPos = cpu.getKnownShipLocation();

                for (int[] component : translations) {
                    String aCoord = opponentBoard.getCoordTranslated(shipPos, component[0], component[1]);
                    if (aCoord != null) {
                        if(opponentBoard.isValidCoordinateSilent(aCoord)) {
                            adjacentSquares.push(aCoord);
                        }
                    }
                }

                if (adjacentSquares.isEmpty()) {
                    System.out.println(cpu.getName() + " drops the ball!");
                    cpu.forgetShip();

                } else {
                    while (!adjacentSquares.isEmpty()) {
                        String potentialTarget = adjacentSquares.pop();
                        Cell cell = opponentBoard.getCell(potentialTarget);
                        if (!cell.isStruck()) {
                            target = potentialTarget;
                            noValidTarget = false;
                            break;
                        }
                    }

                    // It is possible for the CPU to check the reasonable squares surrounding the last ship piece hit and still find no
                    // valid target. This commonly happens when the CPU is looking around the far end of a battleship he hasn't sunk yet.
                    // In that case, there must be extra length on the other side of the cell the battleship was discovered on.
                    if (noValidTarget) {
                        if(cpu.getKnownShipDiscoveryLocation().equals(cpu.getKnownShipLocation())){
                            cpu.forgetShipOrientation();
                        } else {
                            cpu.progressShip(cpu.getKnownShipDiscoveryLocation());
                        }
                    }
                }
            } else { // Hit squares randomly like a dummy :(
                int randomInt;
                if(!checkeredTargets.isEmpty()) {
                    randomInt = (int) (Math.random() * checkeredTargets.size());
                    target = checkeredTargets.get(randomInt);
                } else {
                    randomInt = (int)(Math.random() * validTargets.size());
                    target = validTargets.get(randomInt);
                }
                noValidTarget = false;
            }
        } while (noValidTarget);

        System.out.println(cpu.getName() + " commands a strike at " + target + "!");
        pause(1000);

        if(opponentBoard.strikeBoard(target)){
            // A successful strike was made on the board. Break out of the turn loop.

            // Collect data about the square that was hit to display to the next player.
            lastSquare = target.toUpperCase();
            Cell c = opponentBoard.getCell(lastSquare);

            shipStruck = false;
            shipSank = false;

            if(c.hasShip()){
                shipStruck = true;
                if(cpu.hasKnownShip()){
                    cpu.progressShip(target);
                } else {
                    cpu.discoverShip(target);
                }

                if(c.getShip().getSurvivingUnits() <= 0){
                    shipSank = true;
                    cpu.forgetShip();
                }
            }
        }
        pause(1000);
    }

    private static void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("You shouldn't be seeing this - pause() failed in class BattleshipGame");
        }
    }
}