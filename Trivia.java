import java.util.Objects;
import java.util.Scanner;

public class Trivia {

    Scanner answer = new Scanner(System.in);

    //questions
    String question1 = "What is my favorite food?";
    String question2 = "What is my favorite season?";
    String question3 = "What do I think of robot dogs? Neat, creepy, or nothing?";
    String question4 = "What is my favorite shape?";

    //answers
    String[] answer1 = new String[] {
        "My mom's beef stroganoff",
        "my mom's beef stroganoff",
        "Mom's beef stroganoff",
        "mom's beef stroganoff",
        "Beef stroganoff",
        "beef stroganoff"
    };

    String[] answer2 = new String[] {
            "Winter",
            "winter"
    };

    String[] answer3 = new String[] {
            "Creepy",
            "creepy"
    };

    String[] answer4 = new String[] {
            "Sphere",
            "sphere"
    };

    public boolean firstQuestion() {
        System.out.println(question1);
        String reply = answer.nextLine();
        for (int i = 0; i < 6; i++) {
            if (Objects.equals(reply, answer1[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean secondQuestion() {
        System.out.println(question2);
        String reply = answer.nextLine();
        for (int i = 0; i < 2; i++) {
            if (Objects.equals(reply, answer2[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean thirdQuestion() {
        System.out.println(question3);
        String reply = answer.nextLine();
        for (int i = 0; i < 2; i++) {
            if (Objects.equals(reply, answer3[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean fourthQuestion() {
        System.out.println(question4);
        String reply = answer.nextLine();
        for (int i = 0; i < 2; i++) {
            if (Objects.equals(reply, answer4[i])) {
                return true;
            }
        }
        return false;
    }
}
