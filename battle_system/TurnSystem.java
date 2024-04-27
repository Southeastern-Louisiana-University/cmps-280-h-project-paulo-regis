package battle_system;

import battle_system.Characters.Fighter;
import battle_system.Characters.PauloRegis;
import battle_system.Movelist.Freeze;
import battle_system.Movelist.Move;

import java.util.ArrayList;
import java.util.Objects;

public class TurnSystem {

    private ArrayList<Fighter> turnOrder = new ArrayList<>();
    private Fighter[] fighterList = new Fighter[4];
    private Fighter[] playerList = new Fighter[3];
    private Move[] actionList = new Move[4];

    public TurnSystem(Fighter fighter1,
                      Fighter fighter2,
                      Fighter fighter3,
                      Fighter boss) {
        fighterList[0] = playerList[0] = fighter1;
        fighterList[1] = playerList[1] = fighter2;
        fighterList[2] = playerList[2] = fighter3;
        fighterList[3] = boss;
    }

    public void decideAction(Fighter c, Move action) {
        for (int i = 0; i < fighterList.length; i++) {
            if (fighterList[i].compareTo(c) == 0) {
                actionList[i] = action;
            } else {continue;}
        }
    }

//    public void decideActionBoss() {
//        Fighter boss = fighterList[3];
//        int multiplier = 2;
//        if (0.333 < ((double) boss.getHpCurrent())/boss.getHpMax()) {
//            multiplier = 3;
//        }
//        int rng = (int) (Math.floor(Math.random()*multiplier));
//        decideAction(boss, boss.getMove(rng));
//    }

    public Move getAction(Fighter c) {
        Move action = null;
        for (int i = 0; i < fighterList.length; i++) {
            if (fighterList[i].compareTo(c) == 0) {
                action = actionList[i];
            } else {continue;}
        }

        return action;
    }

    public Move[] getActionList() {return actionList;}

    public void createTurnOrder() {
        // reset the turn order to empty
        if (!turnOrder.isEmpty()) {turnOrder.clear();}

        // choose a player in the list
        for (Fighter c : fighterList) {
            // look at the 0th position in the turn order
            if (turnOrder.isEmpty()) {
                // if there is nothing in the turn order: place the character in the turn order
                turnOrder.add(c);
            } else {
                for (int i = 0; i < turnOrder.size(); i++) {
                    if (!turnOrder.contains(c)) {
                        if (turnOrder.get(i).getStatsActualSingle(5) <= c.getStatsActualSingle(5)) {
                            turnOrder.add(i, c);
                        }
                    }
                }
                if (!turnOrder.contains(c)) {
                    turnOrder.add(c);
                }
            }
        }
    }

    public ArrayList<Fighter> getTurnOrder() {return turnOrder;}

    public void executeRound() {
        for (int i = 0; i < turnOrder.size(); i++) {
            Fighter c = turnOrder.get(i);
            Move action = getAction(c);

            if (Objects.equals(action.getName(), new Freeze().getName())) {
                c.useMoveAoE(action, playerList);
            } else {
                c.useMove(action); // TODO: Set targets prior to using the move for Paulo's moves and for Regenerate
            }
        }
    }

//    private boolean playerTurn = false;
//
//    public boolean isPlayerTurn() {
//        return playerTurn;
//    }
//
//    public void nextTurn() {
//        playerTurn = !playerTurn;
//    }


}
