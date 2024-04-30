package paulomon;

import paulomon.Characters.Fighter;
import paulomon.Movelist.Move;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GUI {

    private Scanner input = new Scanner(System.in);
    private SleepTimer sleepTimer = new SleepTimer();

    private TurnSystem turnSystem;

    private Fighter fighter1;
    private Fighter fighter2;
    private Fighter fighter3;
    private Fighter boss;

    private Fighter[] playerList = new Fighter[3];

    public GUI(TurnSystem turnSystem,
               Fighter fighter1,
               Fighter fighter2,
               Fighter fighter3,
               Fighter boss) {
        this.turnSystem = turnSystem;
        this.fighter1 = playerList[0] = fighter1;
        this.fighter2 = playerList[1] = fighter2;
        this.fighter3 = playerList[2] = fighter3;
        this.boss = boss;
    }

    private int takeInputInt() {
        boolean validValue = true;
        int output = 0;
        do {
            try {
                output = (int) (input.nextDouble());
                validValue = true;
            } catch (InputMismatchException e) {
                input.nextLine();
                validValue = false;
                System.out.print("Please enter a valid value: ");
            }
        } while(!validValue);

        return output;
    }

    public void clearGUI() {
        // how????
    }

    private void generateLineBreak() {
        System.out.println("----------------------------------------------------");
    }
    private void newLine() {
        System.out.println();
    }

    public void generateName(Fighter c) {
        System.out.println(c.getName() + " the " + c.getType() + " " + c.getAnimal() + ": " + c.getHpCurrent() + "/" + c.getHpMax() + " HP");
    }

    public void generateMoves(Fighter c) {
        Move[] moveset = c.getMoveset();
        System.out.println("> "+c.getName()+"'s Moves:");
        for (int i = 0; i < moveset.length; i++) {
            Move move = moveset[i];
            System.out.println("["+(i)+"] "+move.getName()+" (" + move.getDesc() + ")");
//            if (move.getInflicts() != null) {
//                System.out.print(", Inflicts \"" + move.getInflicts().getName() + "\"");
//            } System.out.println(")");
        }
    }

    public void generateStats(Fighter c) {
        int[] stats = c.getStatsActual();
        System.out.println("> Stats:");
        System.out.println("[0] HP : " + stats[0] + " \t[3] SPA: " + stats[3]);
        System.out.println("[1] ATK: " + stats[1] + " \t[4] SPD: " + stats[4]);
        System.out.println("[2] DEF: " + stats[2] + " \t[5] SPE: " + stats[5]);
    }

    public void generateSummary(Fighter c) {
        generateLineBreak();
        generateName(c);
        generateLineBreak();
        generateStats(c);
        generateLineBreak();
        generateMoves(c);
        generateLineBreak();
        newLine();
    }

    public void generateCharacterList() {
        generateLineBreak();
        generateName(fighter1);
        generateName(fighter2);
        generateName(fighter3);
        generateLineBreak();
        newLine();
    }

    public void generateSummaryBoss() {
        Fighter b = boss;
        generateLineBreak();
        System.out.println(b.getName() + " the " + b.getAnimal() + ": " + b.getHpCurrent() + "/" + b.getHpMax());
        generateLineBreak();
        newLine();
    }

    public void generateCharacters() {
        System.out.println("> The Paulomon:");
        for (int i = 0; i < playerList.length; i++) {
            System.out.print("["+i+"] ");
            generateName(playerList[i]);
        }
    }

    public void inspectCharacters() {
        generateCharacters();

        System.out.print("\nChoose a Paulomon to inspect (type -1 to move on): ");
//        boolean validOption = true;
        int option;
        do {
            option = takeInputInt();
            switch (option) {
                case -1:
                    // Moving on
                    break;
                case 0:
                case 1:
                case 2:
                    generateSummary(playerList[option]);
                    generateCharacters();
                    System.out.print("\nChoose a Paulomon to inspect (type -1 to move on): ");
//                    validOption = true;
                    break;
                default:
                    System.out.print("Please type a valid option: ");
//                    validOption = false;
            }
        } while (option != -1);
    }

    public void generateActions() {
        System.out.println("> Actions");
        System.out.println("[0] See Stats");
        System.out.println("[1] Moves");
    }

    public void chooseAction(Fighter c) {
        generateLineBreak();
        generateName(c);
        generateActions();
        boolean validOption = true;
        System.out.print("\nChoose an action: ");
        int option = takeInputInt();

        do {
            if (!validOption) {
                System.out.print("\nChoose an action: ");
                option = takeInputInt();
            }
            switch (option) {
                case 0:
                    generateLineBreak();
                    generateName(c);
                    generateStats(c);
                    generateLineBreak();
                    generateActions();
                    validOption = false;
                    break;
                case 1:
                    generateLineBreak();
                    chooseMove(c);
                    validOption = true;
                    break;
                default:
                    System.out.println("That's not a valid parameter!");
                    generateLineBreak();
                    generateName(c);
                    generateActions();
                    validOption = false;
            }
        } while (option != 1);
    }

    public void chooseMove(Fighter c) {
        generateMoves(c);
        boolean validOption = true;
        System.out.print("\nChoose a move: ");
        int option = takeInputInt();
        do {
            if (!validOption) {
                System.out.print("\nChoose a move: ");
                option = takeInputInt();
            }
            switch (option) {
                case -1:
                    validOption = true;
                    chooseAction(c);
                    break;
                case 0:
                case 1:
                case 2:
                case 3:
                    if (c.getMove(option).isChooseTarget()) {
                        if (chooseTarget(c.getMove((option)), c)) {
                            validOption = true;
                        } else {validOption = false;}
                    } else {validOption = true;}
                    if (validOption) {
                        turnSystem.decideAction(c, c.getMove(option));
                    }
                    break;
                default:
                    System.out.println("That's not a valid parameter!");
                    validOption = false;
            }
        } while (option < -1 || option > 3);
    }

    public void chooseMoveBoss() {
        int multiplier = 2;
        if (0.333 > ((double) boss.getHpCurrent())/boss.getHpMax()) {
            multiplier = 3;
        }
        int rng = (int) (Math.floor(Math.random()*multiplier));
        switch(rng) {
            case 0: // Ray of Frost
                int target = (int) (Math.floor(Math.random()*3));
                boss.getMove(rng).setTarget(playerList[target]);
                break;
            case 1: // Freeze
                break;
            case 2: // Block
                break;
        }

        turnSystem.decideAction(boss, boss.getMove(rng));
    }

    public void generateTargets(Fighter attacker) {
        System.out.println("> Targets for " + attacker.getName() + ":");
        for (int i = 0; i < playerList.length; i++) {
            Fighter player = playerList[i];
            System.out.println("[" + i + "] " + player.getName() + " ("+player.getHpCurrent()+"/"+player.getHpMax()+")");
        }
    }

    public boolean chooseTarget(Move move, Fighter attacker) {
        boolean validOption = true;
        generateTargets(attacker);
        int option;
        do {
            System.out.print("\nChoose a target: ");
            option = takeInputInt();

            if (option < 0 || option > 2) {
//            if (option < -1 || option > 2) {
                System.out.println("That's not a valid parameter!");
                generateLineBreak();
                generateTargets(attacker);
                validOption = false;
            } else {
                if (option >= 0 && option <= 2) {move.setTarget(playerList[option]);}
                validOption = true;
            }
        } while (!validOption);
        return (option != -1);
    }

    public void chooseActionsAll() { // TODO: Allow going back to previous fighters
        for (int i = 0; i < playerList.length; i++) {
            Fighter c = playerList[i];
            if (c.isFainted()) {
                System.out.println(c.getName() + " has fainted and cannot fight!");
                System.out.print("Type anything to move on: ");
                input.nextLine();
            } else { // TODO: Implement being frozen
                chooseAction(playerList[i]);
            }
        } chooseMoveBoss();
    }

    public void generateActionList() {
        System.out.println("> Actions List:");
        Move[] actionList = turnSystem.getActionList();
        for (int i = 0; i < playerList.length; i++) {
            System.out.println("["+i+"] "+playerList[i].getName()+": "+actionList[i].getName());
        }
    }

    public void generateTurnOrder() {
        System.out.println("> Turn Order:");
        ArrayList<Fighter> turnOrder = turnSystem.getTurnOrder();
        for (int i = 0; i < turnOrder.size(); i++) {
                System.out.println("["+i+"] "+turnOrder.get(i).getName());
        }
    }

    public void describeEndingGood() {
        println("Dr. Regis, exhausted, shouts \"I yield!! I yield!\"");
        println("But he still seems to have something up his sleeve...");
    }

    public void describeEndingBad() {
        println("With all three Paulomon on the ground, unconscious and unable to fight,");
        println("Paulo Regis looms over you with an evil gleam in his eye. \"MWAHAHAHAHA,");
        println("you have failed to defeat me!! Now you will succumb to the ice the world");
        println("deserves!\" The gems on his crown glow red, and you suddenly feel a chill");
        println("settle into your very bones. Your movement stalls, and you realize ice is");
        println("creeping up your legs, body, arms, neck... soon, your entire vision turns");
        println("blue, and you are locked away lost in eternal winter.");
    }

    public void describeEndingNeutral() {
        println("Unfortunately, the door being smashed to smithereens also disrupted the structural");
        println("integrity of the surrounding room, causing the icy ceiling to cave in on everybody.");
        println("You and your Paulomon take cover underneath a viny shield Pippin summons from the ground.");
        println("");
        println("As the dust clears, you see Dr. Regis on the ground underneath chunks of debris.");
    }

    private void println(String message) {
        System.out.println(message);
    }
}
