package battle_system;

import battle_system.Characters.Fighter;
import battle_system.Movelist.Move;

public class GUI {

    private Fighter Bubbles;
    private Fighter Nova;
    private Fighter Pippin;
    private Fighter PauloRegis;

    public GUI(Fighter Bubbles,
               Fighter Nova,
               Fighter Pippin,
               Fighter PauloRegis) {
        this.Bubbles = Bubbles;
        this.Nova = Nova;
        this.Pippin = Pippin;
        this.PauloRegis = PauloRegis;
    }

    private void generateLineBreak() {
        System.out.println("----------------------------------------------------");
    }

    public void generateName(Fighter c) {
        System.out.println(c.getName() + " the " + c.getType() + " " + c.getAnimal() + ": " + c.getHpCurrent() + "/" + c.getHpMax());
    }

    public void generateMoves(Fighter c) {
        Move[] moveset = c.getMoveset();
        System.out.println("> Moves:");
        for (int i = 0; i < moveset.length; i++) {
            Move move = moveset[i];
            System.out.print("["+(i+1)+"] "+move.getName()+" (Power " + move.getPower() + ", Accuracy " + move.getAccuracy());
            if (move.getInflicts() != null) {
                System.out.print(", Inflicts " + move.getInflicts().getName());
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
    }

    public void generateCharacterList() {
        generateLineBreak();
        generateName(Bubbles);
        generateName(Nova);
        generateName(Pippin);
        generateLineBreak();
    }

    public void generateSummaryBoss() {
        Fighter pr = PauloRegis;
        System.out.println(pr.getName() + " the " + pr.getAnimal() + ": " + pr.getHpCurrent() + "/" + pr.getHpMax());
    }


    /*
     * [Name] the [Type] [Animal]: [hp]/[maxHp] hp
     * Moves:
     * [1] [move1]
     * [2] [move2]
     * [3] [move3]
     * [4] [move4]
     */
    /*
     * Nova the Fire Cat: 43/100 hp
     * >Options:
     * [1] Stats
     * [2] Moves
     */

    /* TODO: (bossGUI)
     * Paulo Regis the Demigod of Eternal Winter: hp/maxHp
     */

    /* (characterList)
     * Nova the Fire Cat: [hp]/[maxHp] hp
     * Pippin the Fire Cat: [hp]/[maxHp] hp
     * Nova the Fire Cat: [hp]/[maxHp] hp
     */
}
