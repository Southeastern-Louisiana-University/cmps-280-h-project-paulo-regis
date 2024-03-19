package battle_system;

public class turn {

    boolean playerTurn;

    public turn () {
        playerTurn = true;
    }

    public void turnEnd () {
        playerTurn = !playerTurn;
    }
}
