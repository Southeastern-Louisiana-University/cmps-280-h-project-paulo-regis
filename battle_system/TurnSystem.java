package battle_system;

import battle_system.Characters.Fighter;
import battle_system.Characters.PauloRegis;
import battle_system.Movelist.Freeze;
import battle_system.Movelist.Move;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class TurnSystem {
    private SleepTimer sleepTimer = new SleepTimer();

    private ArrayList<Fighter> turnOrder = new ArrayList<>();
    private Fighter[] fighterList = new Fighter[4];
    private Fighter[] playerList = new Fighter[3];
    private Move[] actionList = new Move[4];

    // -1 is bad ending
    // 0 is no ending
    // 1 is good ending
    private int ending = 0;

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

    public Move getAction(Fighter c) {
        Move action = null;
        for (int i = 0; i < fighterList.length; i++) {
            if (fighterList[i].compareTo(c) == 0) {
                action = actionList[i];
            } else {continue;}
        } return action;
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
            System.out.println("===");
            Fighter c = turnOrder.get(i);
            Move action = getAction(c);

            if (Objects.equals(action.getName(), new Freeze().getName())) {
                c.useMoveAoE(action, playerList);
            } else {
                c.useMove(action);
            } sleepTimer.sleep(1000);
        }
    }

    private int determineEnding() {
        if (fighterList[0].isFainted() &&
            fighterList[1].isFainted() &&
            fighterList[2].isFainted()) {
            return -1;
        } else if (fighterList[3].isFainted()) {
            return 1;
        } else {return 0;}
    }

    public int getEnding() {return ending;}

    public void endStep() {
        ending = determineEnding();
    }
}
