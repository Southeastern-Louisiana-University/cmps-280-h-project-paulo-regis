import battleship.BattleshipGame;
import paulomon.PaulomonGame;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        PaulomonGame battle = new PaulomonGame();
        dialogue d = new dialogue();
        Trivia test = new Trivia();

        System.out.println("Welcome to our B-B-B-B-BOSS BATTLE!");

        pause();

        System.out.println("Let's jump RIGHT IN to our FIRST TRIAL, BATTLESHIP!");

        BattleshipGame.playBattleship();

        //move to battle
        d.dialogue(6);
        System.out.println(d.text);
        pause();

        //waking up
        d.dialogue(10);
        System.out.println(d.text);
        pause();

        //introductions
        for (int i = 7; i < 10; i++) {
            d.dialogue(i);
            System.out.println(d.text);
        }
        pause();

        d.dialogue(11);
        System.out.println(d.text);
        pause();

        //regis entrance
        d.dialogue(17);
        System.out.println(d.text);
        pause();

        d.dialogue(21);
        System.out.println(d.text);
        pause();

        d.dialogue(22);
        System.out.println(d.text);
        pause();

        battle.playPaulomon();
        pause();

        if (battle.getEnding() == -1) {
            gameOver();
        }

        d.dialogue(23);
        System.out.println(d.text);
        pause();

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

        d.dialogue(29);
        System.out.println(d.text);
        pause();

        d.dialogue(31);
        System.out.println(d.text);
        System.exit(0);
    }

    public static void pause() {
        try {
            TimeUnit.SECONDS.sleep(3);
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