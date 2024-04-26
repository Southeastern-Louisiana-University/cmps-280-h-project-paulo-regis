package battle_system;

import battle_system.Characters.Fighter;
import battle_system.Movelist.Move;

import java.util.Scanner;

public class GUI {

    private Scanner input = new Scanner(System.in);

    private Fighter _Bubbles;
    private Fighter _Nova;
    private Fighter _Pippin;
    private Fighter _PauloRegis;

    public GUI(Fighter Bubbles,
               Fighter Nova,
               Fighter Pippin,
               Fighter PauloRegis) {
        this._Bubbles = Bubbles;
        this._Nova = Nova;
        this._Pippin = Pippin;
        this._PauloRegis = PauloRegis;
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
        generateName(_Bubbles);
        generateName(_Nova);
        generateName(_Pippin);
        generateLineBreak();
        newLine();
    }

    public void generateSummaryBoss() {
        Fighter pr = _PauloRegis;
        generateLineBreak();
        System.out.println(pr.getName() + " the " + pr.getAnimal() + ": " + pr.getHpCurrent() + "/" + pr.getHpMax());
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
                case -1: // TODO: Remove this after done testing
                    System.out.println("Quitting Program...");
                    break;
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
        } while (option != 1 && option != -1);
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
                    // TODO: Use move
                    break;
                default:
                    System.out.println("That's not a valid parameter!");
                    validOption = false;
            }
        } while (option < -1 || option > 3);
    }
}
