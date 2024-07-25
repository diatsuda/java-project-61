package hexlet.code;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to brain games!");

        String name = Cli.inString("May I get to know your name?");

        System.out.println("Nice to meet you, " + name + "!");
    }
}
