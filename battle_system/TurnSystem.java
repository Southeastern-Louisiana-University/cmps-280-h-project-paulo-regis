package battle_system;

import battle_system.Characters.Fighter;

import java.util.ArrayList;

public class TurnSystem {

    private ArrayList<Fighter> turnOrder = new ArrayList<>();
    private Fighter[] playerList = new Fighter[4];

    public TurnSystem(Fighter fighter1,
                      Fighter fighter2,
                      Fighter fighter3,
                      Fighter boss) {
        playerList[0] = boss;
        playerList[1] = fighter1;
        playerList[2] = fighter2;
        playerList[3] = fighter3;
    }

    public void createTurnOrder() {
        // reset the turn order to empty
        if (!turnOrder.isEmpty()) {turnOrder.clear();}

        // choose a player in the list
        for (Fighter c : playerList) {
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

    private boolean playerTurn = false;

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public void nextTurn() {
        playerTurn = !playerTurn;
    }


}
