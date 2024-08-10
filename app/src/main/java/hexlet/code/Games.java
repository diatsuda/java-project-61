package hexlet.code;

import static hexlet.code.Cli.say;

public class Games {

    public static boolean isGameStarted = false;

    public static void exit() { };

    public static void greet() {
        say("May I get to know your name?");
        String name = Cli.takeString();
        say("Nice to meet you, " + name + "!");
        start(name);
    };

    public static void start(String name) {
        if (!isGameStarted) {
            Cli.say("Please enter the game number and press Enter");
            isGameStarted = true;
        }
        say("1 - Greet");
        say("2 - Even");
        say("3 - Calc");
        say("0 - Exit");
        Integer choice = Cli.takeInt();
        switch (choice) {
            case 0: exit(); break;
            case 1: greet(); break;
            case 2: gameEven(name); break;
            case 3: gameCalc(name); break;
            default:
                say("Sorry, I can not understand what " + choice + " means");
                start(name);
                break;
        }
    }

    public static void gameEven(String name) {
        say("In this game, you have to determine whether the value is even or not.");
        say("If even, enter yes. Otherwise enter no.");
        say("Any other reply is considered a mistake anyway, so be cautious.");
        say("In order to win, you have to give three correct answers in a row.");
        int correctAnswers = 0;
        int randomMultiplyCoef = 10;

        while (correctAnswers < 3) {
            double randomSeed = Math.random() * randomMultiplyCoef;
            int randomNumber = (int) randomSeed;
            boolean isEven = (randomNumber % 2 == 0);
            say("Is " + randomNumber + " even? [yes / no]");
            String reply = (Cli.takeString().toLowerCase());

            if ((reply.equals("yes") && isEven) || (reply.equals("no") && !isEven)) {
                correctAnswers++;
                say("Correct!");
            } else {
                correctAnswers = 0;
                say("Answer incorrect. Counter was reset.");
            }
        }
        say("Congratulations, " + name + "! You win!");
        start(name);
    }

    public static void gameCalc(String name) {
        say("In this game, you have to calculate some simple arithmetic expressions.");
        say("Just enter the result of the expression.");
        say("Any other reply is considered a mistake, so be cautious.");
        say("So, to succeed, you have to give three correct answers consequently.");
        int correctAnswers = 0;
        int randomMultiplyCoef = 10;


        while (correctAnswers < 3) {
            var randomNumA = (int) (Math.random() * randomMultiplyCoef + Math.random() * randomMultiplyCoef);
            var randomNumB = (int) (Math.random() * randomMultiplyCoef + Math.random() * randomMultiplyCoef);
            int expectedResult = 0;
            char operatorSymbol = ' ';

            if (Math.random() >= 0.5 && Math.random() < 0.5) {
                expectedResult = randomNumA + randomNumB;
                operatorSymbol = '+';
            }
            else if (Math.random() < 0.5 && Math.random() >= 0.5) {
                expectedResult = randomNumA - randomNumB;
                operatorSymbol = '-';
            }
            else {
                expectedResult = randomNumA * randomNumB;
                operatorSymbol = '*';
            };

            say(randomNumA + " " + operatorSymbol + " " + randomNumB + " = ...");
            var reply = (Cli.takeInt());

            if (reply == expectedResult) {
                correctAnswers++;
                say("Correct!");
            } else {
                correctAnswers = 0;
                say("Wrong answer. Counter was reset.");
            }
        }
        start(name);
    };

    public static void main(String[] args) {
    }
}