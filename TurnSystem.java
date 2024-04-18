public class TurnSystem {
    private boolean playerTurn = false;

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public void nextTurn() {
        playerTurn = !playerTurn;
    }
}
