package battle_system;

import battle_system.Characters.*;

public class BattleEngine {

    public static Fighter _PauloRegis = new PauloRegis();
    public static Fighter _Bubbles = new Bubbles(_PauloRegis);
    public static Fighter _Nova = new Nova(_PauloRegis);
    public static Fighter _Pippin = new Pippin(_PauloRegis);

    public static TurnSystem _TurnSystem = new TurnSystem(_Bubbles, _Nova, _Pippin, _PauloRegis);
    public static GUI _GUI = new GUI(_TurnSystem, _Bubbles, _Nova, _Pippin, _PauloRegis);

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



        // Stage 0: Declare a new round and do pre-round things

        // Stage 1.1: Declare a fighter's turn
        // Stage 1.2: Choose that fighter's moves
//        _GUI.chooseAction(_Nova);
        // Stage 1.3: Move to the next fighter's turn
        _GUI.chooseActionsAll();
//        _GUI.generateActionList();


        // Stage 2: Decide turn order
        _TurnSystem.createTurnOrder();
//        _GUI.generateTurnOrder();

        // Stage 3: Execute round
        _TurnSystem.executeRound();

        // Stage 4: End round
    }
}
