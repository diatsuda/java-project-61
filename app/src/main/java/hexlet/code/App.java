package hexlet.code;

public class App {

    public static void greet() {
        String name = Cli.takeString("May I get to know your name?");
        System.out.println("Nice to meet you, " + name + "!");
    }

    public static void main(String[] args) {
        Cli.say("Welcome to brain games!");
        Cli.say("Please enter the game number and press Enter");
        Cli.say("1 - Greet\n0 - Exit");
        Integer choice = Cli.takeInt("Please enter the game number and press Enter");
        switch (choice) {
            case 0: break;
            case 1: {
                greet(); break;
            }
            default: break;
        }
    }
}
