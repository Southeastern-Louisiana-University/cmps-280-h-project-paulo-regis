import paulomon.SleepTimer;

public class Main {
    private static SleepTimer sleepTimer = new SleepTimer();

    public static void main(String[] args) {


        System.out.println("Welcome to my B-B-B-B-BOSS BATTLE!");

        sleepTimer.sleep(1000);

        System.out.println("I am Paulo Regis. Let's jump RIGHT IN to our FIRST TRIAL, BATTLESHIP!");
    }

    public static void gameOver() {
        System.out.println("\t\t\t\t\t\t\t     ||||");
        System.out.println("\t\t\t\t\t\t\t     |||||");
        System.out.println("\t\t\t\t\t\t\t     ||||||");
        System.out.println("\t\t\t\t\t\t\t     ||||||");
        System.out.println("\t\t\t\t\t\t\t     |||||||");
        System.out.println("\t\t\t\t\t\t\t     |||||||");
        System.out.println("\t\t   ////\\\\\\\\   ////\\\\\\\\   |||||||   ////\\\\\\\\   ////\\\\\\\\");
        System.out.println("\t\t   ||||||||   ||||||||   ||||||||  ||||||||   ||||||||");
        System.out.println("||||||\\\\   ||||||||   ||||||||   ||||||||  ||||||||   ||||||||");
        System.out.println("|||||\\\\\\\\  ||||||||   ||||||||   ||||||||  ||||||||   ||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("\t\t|||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("\t\t|||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("\t\t|||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("\t\t||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("GAME OVER");
        System.exit(0);
    }
}