package battle_system;

import battle_system.Characters.Fighter;
import battle_system.Movelist.Move;

import java.util.ArrayList;
import java.util.Scanner;

public class GUI {

    private Scanner input = new Scanner(System.in);

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
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
        this.fighter3 = fighter3;
        this.boss = boss;

        playerList[0] = fighter1;
        playerList[1] = fighter2;
        playerList[2] = fighter3;
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
        System.out.println(c.getName() + " the " + c.getType() + " " + c.getAnimal() + ": " + c.getHpCurrent() + "/" + c.getHpMax());
    }

    public void generateMoves(Fighter c) {
        Move[] moveset = c.getMoveset();
        System.out.println("> Moves:");
        for (int i = 0; i < moveset.length; i++) {
            Move move = moveset[i];
            System.out.print("["+(i)+"] "+move.getName()+" (Power " + move.getPower() + ", Accuracy " + move.getAccuracy());
            if (move.getInflicts() != null) {
                System.out.print(", Inflicts \"" + move.getInflicts().getName() + "\"");
            } System.out.println(")");
        }
    }

    public void generateStats(Fighter c) {
        int[] stats = c.getStatsActual();
        System.out.println("> Stats:");
        System.out.println("[0] HP : " + stats[0] + "\t[3] SPD: " + stats[3]);
        System.out.println("[1] ATK: " + stats[1] + "\t[4] SPA: " + stats[4]);
        System.out.println("[2] DEF: " + stats[2] + "\t[5] SPE: " + stats[5]);
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
        int option = input.nextInt();

        do {
            if (!validOption) {
                System.out.print("\nChoose an action: ");
                option = input.nextInt();
            }
            switch (option) {
//                case -1: // TODONE: Remove this after done testing
//                    System.out.println("Going to previous fighter...");
////                    return 1;
//                    break;
                case 0:
                    System.out.println("Generating Stats...");
                    generateLineBreak();
                    generateName(c);
                    generateStats(c);
                    generateLineBreak();
                    generateActions();
                    validOption = false;
                    break;
                case 1:
                    System.out.println("Generating Moves...");
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
        } while (option != 1/* && option != -1*/);
//        System.out.println("Option " + option + " chosen!");
    }

    public void chooseMove(Fighter c) {
        generateMoves(c);
        boolean validOption = true;
        System.out.print("\nChoose a move: ");
        int option = input.nextInt();
        do {
            if (!validOption) {
                System.out.print("\nChoose a move: ");
                option = input.nextInt();
            }
            switch (option) {
                case -1:
                    System.out.println("Exiting...");
                    validOption = true;
                    chooseAction(c);
                    break;
                case 0:
                case 1:
                case 2:
                case 3:
                    validOption = true;
                    System.out.println("Using move #" + option + "...");
                    turnSystem.decideAction(c, c.getMove(option));
                    break;
                default:
                    System.out.println("That's not a valid parameter!");
                    validOption = false;
            }
        } while (option < -1 || option > 3);
    }

    public void chooseActionsAll() { // TODO: Allow going back to previous fighters
        for (int i = 0; i < playerList.length; i++) {
            chooseAction(playerList[i]);
        }
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
}
