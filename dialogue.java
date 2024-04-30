public class dialogue {

    String text;

    public String dialogue (int num) {
        switch (num) {
            case 1:
                text = "Directive: Sink the enemy battleships.";
                break;
            case 2:
                text = "Direct hit!";
                break;
            case 3:
                text = "You missed!";
                break;
            case 4:
                text = "You sunk an enemy battleship. Good work soldier.";
                break;
            case 5:
                text = "The enemy has sunk one of your battleships. Get your head in the game soldier.";
                break;
            case 6:
                text = "You've risen out of the battle victorious. You feel accomplished, the smell of freedom in the air. \n" +
                        "As you simmer in the moment, something approaches from behind. *thwack!* \n" +
                        "You've been knocked unconscious. \n";
                break;
                //change it to wake up first and then be introduced to each paulo-mon.
                //This way you can read the name tags and see the stats.
                //Each paulo-mon will be used every round turn based.
            case 7:
                text = "Bubbles: the pink lizard fish (aka the water axolotl power house)!";
                break;
            case 8:
                text = "Nova: The fiery feline fiend (aka the cat with infernal powers)!";
                break;
            case 9:
                text = "Pippin: The best boy (aka the dog with power of grass)!";
                break;
            case 10:
                text = "You wake up in a mysterious place unsure of how you got there. \n" +
                    "Your eyes are facing the sky which looks like a bright blur as you blink to clear your vision. \n" +
                    "Your Paulo-mons surround you, worried if you're ok. \n";
                break;
            case 11:
                text = "\"Are y'all happy to see me?\" ";
                break;
            case 12:
                text = "You reach into your pocket discovering a pocket watch. It's silver in color and quite clean for " +
                        "a random old watch you've just found. ";
                break;
            case 13:
                text = "\"Huh? The hands are frozen. Maybe I can swap the battery out or at least pawn it\" ";
                break;
            case 14:
                text = "In fear, you quickly squeeze the pocket watch in your pocket. " +
                        "You've been transported not long before the moment you've just experienced. " +
                        "The watch seems to have a slight crack in the glass and is a little tarnished. ";
                break;
            case 15:
                text = "You quickly squeeze the pocket watch in your pocket. " +
                        "You've been transported not long before the moment you've just experienced. " +
                        "The watch seems to have a few more cracks in the glass and is a pretty tarnished. ";
                break;
            case 16:
                text = "You quickly squeeze the pocket watch in your pocket. " +
                        "You've been transported not long before the moment you've just experienced. " +
                        "The watch is completely shattered and is unable to be salvaged. " +
                        "You're no longer able to time jump. ";
                break;
            case 17:
                text = "A tall dark figure enters, it's shadow draping over you. \n" +
                        "You stare into the figure's glowing eyes as it pulls it's hood back. \n" +
                        "It's Dr. Regis! Why does he seem so ill-tempered? What could possibly make him so angry? \n";
                break;
            case 18:
                text = "The Paulo-mon whimper in fear. Pippin tucks his head under your arm and points at the top of Dr. Regis' head. ";
                break;
            case 19:
                text = "Nova bites your wrist and points at the top of Dr. Regis' head. "; //scratch
            case 20:
                text = "Pippin tucks his head under your arm and points at the top of Dr. Regis' head. "; //scratch
            case 21:
                text = "Dr. Regis freezes the surrounding area. There's no escape! \n" +
                        "You and your Paulo-mon must fight to survive. ";
                break;
            case 22:
                text = "Nova lunges in front of you to protect you. \n" +
                        "The rest follow in pursuit, awaiting your command. ";
                break;
            case 23:
                text =  "He's kneeling on the ground, head low. \n" +
                        "He looks up at you and says, \"Heh... You've beat me.\" \n" +
                        "He quickly slashes the air around him with his hand creating a shell of ice. \n" +
                        "He peers at you through a slot in the ice. \n" +
                        "He says to you, \"Answer these three questions and I will spare your world. \n" +
                        "Answer them incorrectly and I'll begin the next ice age. \n" +
                        "Everything you know and love will be extinct!\" \n";
                break;
            case 24:
                text = "He looks at his former pets standing around you, \"for every question you get wrong, \n" +
                        "I'll freeze one of these three.";
                break;
            case 25:
                text = "What do you do?";
                break;
            case 26:
                text = "You say to him: \"Fine. I'll answer your questions. I won't let you destroy this world.\" ";
                break;
            case 27:
                text = "You say to him: \"No! I'm done dealing with you. I won't give you the time of day.\" ";
                break;
            case 28:
                text = "You walk up to his ice shell. You inspect the slot. You calmly turn around " +
                        "and release the juiciest fart known to man into the slot. That taco bell did " +
                        "not sit well with you. "; //finish
                break;


            case 29:
                text = "Dr. Regis says, \"Fine. A deal's a deal. I won't freeze your world. What fun would that be anyways.\" \n" +
                        "You hug your Paulo-mon friends, assuring them everything is ok. Dr. Regis turns around and goes to fly away. \n" +
                        "Nova looks up at you then at his crown. You nod to Nova and he nods back. \n" +
                        "You pick Nova up, spin, and cast Nova over to Dr. Regis. Nova uses his flame powers to boost himself. \n" +
                        "He manages to knock the crown off of Dr. Regis' head, freeing him from the curse. \n" +
                        "Dr. Regis falls to the ground regaining consciousness. He looks up at you. \n" +
                        "He says to you, \"thank you for freeing me, my student. I couldn't control myself. \n" +
                        "It was like the crown had a mind of its own\" You return the Paulo-mon back to Dr. Regis \n" +
                        "and they all walk off grateful for your help. ";
                break;
            case 30:
                text = "With all three Paulomon on the ground, unconscious and unable to fight, \n" +
                        "Paulo Regis looms over you with an evil gleam in his eye. \"MWAHAHAHAHA, \n" +
                        "you have failed to defeat me!! Now your world will succumb to the icy hell-scape \n" +
                        "it deserves!\" The gems on his crown start to violently glow red. \n" +
                        "You suddenly feel a chill settle into your very bones, your movement stalls, \n" +
                        "and you start to realize ice is creeping up your legs, body, arms, neck... \n" +
                        "soon, your entire vision turns blue as a tear drop streams down your cheek freezing halfway down, \n" +
                        "and you are locked away lost in eternal winter. You've been defeated.";
                break;
            case 31:
                text = "The End.";
                break;


        }
//For trivia, possibly freeze a Paulo-mon with each question answered wrong.
// If time jumps have not been used yet, then player can use them on trivia twice.
// There will be no time jump for the third and final question if they've been used.
// The balance of the world is in your hand.
// Showcase pocket watch that is stuck on a specific time when you look at it.
// Whenever you get to the next stage then it'll set to that time for you to jump back to.
// You won't know it's for time travel until you've been defeated.
// When you jump back you feel weaker or faint. Maybe you look pale or the pocket watch looks different.
        return text;
    }
}
