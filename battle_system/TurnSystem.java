package battle_system;

import battle_system.Characters.Fighter;
import battle_system.Movelist.Move;

import java.util.ArrayList;

public class TurnSystem {

    private ArrayList<Fighter> turnOrder = new ArrayList<>();
    private Fighter[] fighterList = new Fighter[4];
    private Move[] actionList = new Move[4];

    public TurnSystem(Fighter fighter1,
                      Fighter fighter2,
                      Fighter fighter3,
                      Fighter boss) {
        fighterList[0] = fighter1;
        fighterList[1] = fighter2;
        fighterList[2] = fighter3;
        fighterList[3] = boss;
    }

    public void decideAction(Fighter c, Move action) {
        for (int i = 0; i < fighterList.length; i++) {
            if (fighterList[i].compareTo(c) == 0) {
                actionList[i] = action;
            } else {continue;}
        }
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
