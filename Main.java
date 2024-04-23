import battleship.BattleshipGame;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        TurnSystem turn = new TurnSystem();

        System.out.println("Welcome to my B-B-B-B-BOSS BATTLE!");

        pause();

        System.out.println("I am Paulo Regis. Let's jump RIGHT IN to our FIRST TRIAL, BATTLESHIP!");

        BattleshipGame.playBattleship();

        //paulomon battle here

        Trivia test = new Trivia();

        pause();

        //dialogue for winning the paulomon battle

        if (!test.firstQuestion()) {
            //dialogue for getting a question wrong
            gameOver();
        }
        //dialogue for first question right

        if (!test.secondQuestion()) {
            //question wrong
            gameOver();
        }
        //dialogue for secondQ correct

        if (!test.thirdQuestion()) {
            //etc.
            gameOver();
        }

        if (!test.fourthQuestion()) {
            //etc.
            gameOver();
        }

        //dialogue for winning the game
        System.exit(0);
    }

    public static void pause() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void gameOver() {
        System.out.println("\t\t\t\t      ||||");
        System.out.println("\t\t\t\t      |||||");
        System.out.println("\t\t\t\t      ||||||");
        System.out.println("\t\t\t\t      ||||||");
        System.out.println("\t\t\t\t      |||||||");
        System.out.println("\t\t\t\t      |||||||");
        System.out.println("\t\t   ////\\\\\\\\   |||||||   ////\\\\\\\\   ////\\\\\\\\");
        System.out.println("\t\t   ||||||||   ||||||||  ||||||||   ||||||||");
        System.out.println("||||||\\\\   ||||||||   ||||||||  ||||||||   ||||||||");
        System.out.println("|||||\\\\\\\\  ||||||||   ||||||||  ||||||||   ||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("\t\t|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("\t\t|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("\t\t|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("\t\t||||||||||||||||||||||||||||||||||||||");
        System.out.println("GAME OVER");
        System.exit(0);
    }
}