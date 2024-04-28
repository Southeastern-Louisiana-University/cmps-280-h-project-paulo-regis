package battle_system;

import battle_system.Characters.*;

public class BattleEngine {

    private static SleepTimer sleepTimer = new SleepTimer();

    public static Fighter _PauloRegis = new PauloRegis();
    public static Fighter _Bubbles = new Bubbles(_PauloRegis);
    public static Fighter _Nova = new Nova(_PauloRegis);
    public static Fighter _Pippin = new Pippin(_PauloRegis);

    public static TurnSystem _TurnSystem = new TurnSystem(_Bubbles, _Nova, _Pippin, _PauloRegis);
    public static GUI _GUI = new GUI(_TurnSystem, _Bubbles, _Nova, _Pippin, _PauloRegis);

    public static int round = 0;
    public static boolean gameOver = false;

    public static void main(String[] args) {
        while (!gameOver) {
            round++;
            System.out.println("===");
            System.out.println(">>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<" + ((round>=10) ? "<" : ""));
            System.out.println("---------------- Round " + round + " ----------------");
            System.out.println(">>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<" + ((round>=10) ? "<" : ""));
            _GUI.chooseActionsAll();

            // Stage 2: Decide turn order
            _TurnSystem.createTurnOrder();

            // Stage 3: Execute round
            _TurnSystem.executeRound();

            // Stage 4: End round
            _TurnSystem.endStep();

            // Stage 5: End the game, if need be
            if (_TurnSystem.getEnding() != 0) {gameOver = true;}
        }

        // Enact ending
        if (_TurnSystem.getEnding() > 0) {
            _GUI.describeEndingGood();
        } else if (_TurnSystem.getEnding() < 0) {
            _GUI.describeEndingBad();
        } else {
            System.out.println("INVALID ENDING");
        }
    }
}
