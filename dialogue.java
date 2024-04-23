public class dialogue {

    String text;

    public String dialogue (int num) {
        switch (num) {
            case 1:
                text = "Directive: Sink the enemy battleships.";
            case 2:
                text = "Direct hit!";
            case 3:
                text = "You missed!";
            case 4:
                text = "You sunk an enemy battleship. Good work soldier.";
            case 5:
                text = "The enemy has sunk one of your battleships. get your head in the game soldier.";
            case 6:
                text = "Choose your Paulo-mon";
                //change it to wake up first and then be introduced to each paulo-mon.
                //This way you can read the name tags and see the stats.
                //Each paulo-mon will be used every round turn based.
            case 7:
                text = "Bubbles: the pink lizard fish (aka the water axolotl power house)";
            case 8:
                text = "Nova: The fiery feline fiend (aka the cat with infernal powers)";
            case 9:
                text = "Pippin: The best boy (aka the dog with power of grass)";
            case 10:
                text = "You've selected Bubbles. Good luck to both you and your Paulo-mon.";
            case 11:
                text = "You've selected Nova. Good luck to both you and your Paulo-mon.";
            case 12:
                text = "You've selected Pippin. Good luck to both you and your Paulo-mon.";
            case 13:
                text = "You wake up in a mysterious place unsure of how you got there. " +
                        "Your eyes are facing the sky which looks like a bright blur as you blink to clear your vision. " +
                        "Your Paulo-mon climbs on top of you and licks your face. ";
            case 14:
                text = "\"Are you happy to see me, Bubbles?\" ";
            case 15:
                text = "\"Are you happy to see me, Nova?\" ";
            case 16:
                text = "\"Are you happy to see me, Pippin?\" ";
            case 17:
                text = "A tall dark figure enters, it's shadow draping over you. " +
                        "You stare into the figure's glowing eyes as it pulls it's hood back. " +
                        "It's Dr. Regis! Why does he seem so ill-tempered? What could possibly make him so angry? ";
            case 18:
                text = "Bubble tugs on your sleeve and points at the top of Dr. Regis' head. ";
            case 19:
                text = "Nova bights your wrist and points at the top of Dr. Regis' head. ";
            case 20:
                text = "Pippin tucks his head under your arm and points at the top of Dr. Regis' head. ";
            case 21:
                text = "You notice a gold crown with 3 big red gems on the front. It's the Ice King's crown! " +
                        "Dr. Regis is consumed under the psychosis of the crown. " +
                        "He freezes the surrounding area. There's no escape! " +
                        "You and your Paulo-mon must fight to survive. ";
            case 22:
                text = "Your Paulo-mon lunges in front of you to protect you. " +
                        "You must aid it in the fight against Dr. Regis. ";
            case 23:
                text = "Dr. Regis has been defeated. He's kneeling on the ground, head low." +
                        "He looks up at you and says, \"Heh... You've beat me.\" " +
                        "He quickly slashes the air around him with his hand creating a shell of ice. " +
                        "He peers at you through a slot in the ice." +
                        "He says to you, \"answer these three questions and I will spare your world. " +
                        "Answer them incorrectly and I'll begin the next ice age. " +
                        "Everything you know and love will be extinct!\" ";
            case 24:
                text = "He looks at his former pets standing around you, \"for every question you get wrong, " +
                        "I'll freeze one of these three.";
            case 25:
                text = "What do you do?";
            case 26:
                text = "You say to him: \"Fine. I'll answer your questions. I won't let you destroy this world.\" ";
            case 27:
                text = "You say to him: \"No! I'm done dealing with you. I won't give you the time of day.\" ";
            case 28:
                text = "You walk up to his ice shell. You inspect the slot. You calmly turn around " +
                        "and release the juiciest fart known to man into the slot. That taco bell did " +
                        "not sit well with you. "; //finish

                /*
            case 29:
                text =
            case 30:
                text =
            case 31:
                text =
            case 32:
                text =
            case 33:
                text =
            case 34:
                text =
                */



        }
//For trivia, possibly freeze a Paulo-mon with each question answered wrong.
// If time jumps have not been used yet, then player can use them on trivia twice.
// There will be no time jump for the third and final question if they've been used.
// The balance of the world is in your hand.
// Showcase pocket watch that is stuck on a specific time when you look at it.
// Whenever you get to the next stage then it'll set to that time for you to jump back to.
// You won't know it's for time travel until you've been defeated.
// When you jump back you feel weaker or faint. Maybe yo look pale or the pocket watch looks different.
        return text;
    }
}
