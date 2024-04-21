package battle_system;

import battle_system.Characters.Fighter;
import battle_system.Movelist.Move;

public class GUI {

    private Fighter Bubbles;
    private Fighter Nova;
    private Fighter Pippin;

    public GUI(Fighter Bubbles,
               Fighter Nova,
               Fighter Pippin) {
        this.Bubbles = Bubbles;
        this.Nova = Nova;
        this.Pippin = Pippin;
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
     *
     *
     * Moves:
     * [1] Scorching Scratch
     * [2] [move2]
     * [3] Dodge
     * [4] Flee
     */

    /* TODO: (bossGUI)
     * Paulo Regis the Demigod of Eternal Winter: hp/maxHp
     */

    /* (characterList)
     * Nova the Fire Cat: [hp]/[maxHp] hp
     * Pippin the Fire Cat: [hp]/[maxHp] hp
     * Nova the Fire Cat: [hp]/[maxHp] hp
     */

    /* (character summary)
     * [Name] the [Type] [Animal]: [hp]/[maxHp] hp
     * -------------------------------------------
     * > Stats:
     * [0] HP : [hp]   [3] SPD: [spD]
     * [1] ATK: [atk]  [4] SPA: [spA]
     * [2] DEF: [def]  [5] SPE: [spe]
     * -------------------------------------------
     * > Moves:
     * [1] [move1] (Power [p], Accuracy [a], Inflicts [i])
     * [2] [move2] (Power [p], Accuracy [a], Inflicts [i])
     * [3] [move3] (Power [p], Accuracy [a], Inflicts [i])
     * [4] [move4] (Power [p], Accuracy [a], Inflicts [i])
     * -------------------------------------------
     */
}
