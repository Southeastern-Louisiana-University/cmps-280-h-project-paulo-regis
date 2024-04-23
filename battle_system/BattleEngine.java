package battle_system;

import battle_system.Characters.*;

public class BattleEngine {

    public static Fighter _PauloRegis = new PauloRegis();
    public static Fighter _Bubbles = new Bubbles(_PauloRegis);
    public static Fighter _Nova = new Nova(_PauloRegis);
    public static Fighter _Pippin = new Pippin(_PauloRegis);

    public static GUI GUI = new GUI(_Bubbles, _Nova, _Pippin, _PauloRegis);

    public static void main(String[] args) {

        GUI.generateSummaryBoss();
        GUI.generateSummary(_Bubbles);
        GUI.generateSummary(_Nova);
        GUI.generateSummary(_Pippin);
        // Stage 1: Choose moves
        // Stage 2: Decide turn order
        // Stage 3: Execute round
        // Stage 4: End round
    }
}
