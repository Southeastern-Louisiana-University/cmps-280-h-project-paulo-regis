package battle_system;

import battle_system.Characters.*;

public class BattleEngine {

    public static Fighter _PauloRegis = new PauloRegis();
    public static Fighter _Bubbles = new Bubbles(_PauloRegis);
    public static Fighter _Nova = new Nova(_PauloRegis);
    public static Fighter _Pippin = new Pippin(_PauloRegis);

    public static GUI _GUI = new GUI(_Bubbles, _Nova, _Pippin, _PauloRegis);

    public static void main(String[] args) {

//        _GUI.generateSummaryBoss();
//        _GUI.generateSummary(_Bubbles);
//        _GUI.generateSummary(_Nova);
//        _GUI.generateSummary(_Pippin);

//        _GUI.generateName(_PauloRegis);
//        _GUI.generateStats(_PauloRegis);
//        _GUI.generateMoves(_PauloRegis);

//        _GUI.generateSummary(_PauloRegis);


//        _GUI.generateCharacterList();

        // Stage 1: Choose moves
        _GUI.chooseAction(_Nova);


        // Stage 2: Decide turn order
        // Stage 3: Execute round
        // Stage 4: End round
    }
}
