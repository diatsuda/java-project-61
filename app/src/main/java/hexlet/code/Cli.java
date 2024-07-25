package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String takeString(String message) {
        System.out.println(message);
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
    public static Integer takeInt(String message) {
        System.out.println(message);
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static void say(String message) {
        System.out.println(message);
    }

}
