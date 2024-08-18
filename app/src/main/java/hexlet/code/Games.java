package hexlet.code;

import static hexlet.code.Cli.say;
import static hexlet.code.Cli.random;

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
        say("4 - GCD");
        say("5 - Progression");
        say("0 - Exit");
        Integer choice = Cli.takeInt();
        switch (choice) {
            case 0: exit(); break;
            case 1: greet(); break;
            case 2: gameEven(name); break;
            case 3: gameCalc(name); break;
            case 4: gameGCD(name); break;
            case 5: gameProgression(name); break;
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

        while (correctAnswers < 3) {
            var randomNumber = random(1, 100);
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

        while (correctAnswers < 3) {
            var randomNumA = random(1, 100);
            var randomNumB = random(1, 100);
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
        say("Congratulations, " + name + "! You win!");
        start(name);
    };

    public static void gameGCD(String name) {
        say("In this game, you have to calculate a Greatest Common Divisor of two numbers.");
        say("Just enter the value you've calculated.");
        say("Any other reply is considered a mistake, so be cautious.");
        say("In order to succeed, you have to give three correct answers consequently.");
        int correctAnswers = 0;

        while (correctAnswers < 3) {
            var randomNumA = random(1, 100);
            var randomNumB = random(1, 100);
            int expectedResult = 0;
            var randomMinAB = Math.min(randomNumA, randomNumB);
            if (randomMinAB < 0 && randomMinAB == randomNumA) randomNumA = 1;
            else if (randomMinAB < 0 && randomMinAB == randomNumB) randomNumB = 1;
            for (int i = randomMinAB; i > 0; i--) {
                if (randomNumA % i == 0 && randomNumB % i == 0) {
                    expectedResult = i;
                    break;
                }
            };

            say("Greatest Common Divisor of " + randomNumA + " and " + randomNumB + " equals...");
            var reply = (Cli.takeInt());

            if (reply == expectedResult) {
                correctAnswers++;
                say("Correct!");
            } else {
                correctAnswers = 0;
                say("Wrong answer. Counter was reset.");
            }
        }
        say("Congratulations, " + name + "! You win!");
        start(name);
    };

    public static void gameProgression(String name) {
        say("In this game, you have to calculate a randomly picked member of an arithmetic row.");
        say("Just enter the value you consider the most suitable.");
        say("Any other reply is considered a mistake, so be cautious.");
        say("In order to succeed, you have to give three correct answers consequently.");
        int correctAnswers = 0;

        while (correctAnswers < 3) {
            int quantityOfNumbers = random(5, 10);
            int placeholderPosition = random(0, quantityOfNumbers-1);
            int memberOfRow = random(0, 100); // first member of row
            int incrementOfRow = random(0, 100);
            int expectedResult = 0;

            say("What number is missing in the progression:");
            for (int i = 0; i < quantityOfNumbers; i++) {
                if(i == placeholderPosition) {
                    System.out.print(".. ");
                    expectedResult = memberOfRow;
                    memberOfRow += incrementOfRow;
                    continue;
                };

                System.out.print(memberOfRow);
                memberOfRow += incrementOfRow;

                if (i < quantityOfNumbers-1) {
                    System.out.print(", ");
                } else {
                    say("");
                    break;
                };
            };

            var reply = (Cli.takeInt());

            if (reply == expectedResult) {
                correctAnswers++;
                say("Quite right!");
            } else {
                correctAnswers = 0;
                say("Wrong answer. The correct one was " + expectedResult + ". Let's try again, " + name + "!");
            }
        }
        say("Congratulations, " + name + "! You win!");
        start(name);
    };

    public static void main(String[] args) {
    }
}