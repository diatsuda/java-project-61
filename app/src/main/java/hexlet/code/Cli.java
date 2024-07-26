package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String takeString() {
        Scanner in = new Scanner(System.in);
        String response = in.nextLine().toString();
        return (response);
    }

    public static Integer takeInt() {
        Scanner in = new Scanner(System.in);
        String response = in.nextLine();
        try {
            Integer.parseInt(response);
        } catch (Exception exception) {
            System.out.println("You entered a non-integer value. The program will exit.");
            return 0;
        }
        return Integer.parseInt(response);
    }

    public static void say(String message) {
        System.out.println(message);
    }

}
