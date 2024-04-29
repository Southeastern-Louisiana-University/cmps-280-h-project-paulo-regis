package paulomon;
// ----------------------------------------------
//              JAVA PAULOMON BATTLE
// ----------------------------------------------
// A text-based companion battle against the
// Doctor hell-bent on freezing the world over.
// Heavily inspired by Pokémon, and playable
// entirely within an IDE's output log.
//
//  Written by Christian Bankovic

import paulomon.Characters.*;

public class PaulomonGame {

    private SleepTimer sleepTimer = new SleepTimer();

    private Fighter _PauloRegis = new PauloRegis();
    private Fighter _Nova = new Nova(_PauloRegis);
    private Fighter _Pippin = new Pippin(_PauloRegis);
    private Fighter _Bubbles = new Bubbles(_PauloRegis);

    private TurnSystem _TurnSystem = new TurnSystem(_Nova, _Pippin, _Bubbles, _PauloRegis);
    private GUI _GUI = new GUI(_TurnSystem, _Nova, _Pippin, _Bubbles, _PauloRegis);

    private int round = 0;
    private boolean gameOver = false;

    public void playPaulomon() {

        describeCharacterIntros();

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
        enactEnding();
    }

    public void describeCharacterIntros() {
        _GUI.inspectCharacters();
    }

    public void enactEnding() {
        if (_TurnSystem.getEnding() > 0) {
            _GUI.describeEndingGood();
        } else if (_TurnSystem.getEnding() < 0) {
            _GUI.describeEndingBad();
        } else {
            System.out.println("INVALID ENDING");
        }
    }
}
