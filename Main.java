import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        TurnSystem turn = new TurnSystem();

        System.out.println("Welcome to my B-B-B-B-BOSS BATTLE!");

        pause();

        System.out.println("I am Paulo Regis. Let's jump RIGHT IN to our FIRST TRIAL, BATTLESHIP!");
    }

    public static void pause() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}