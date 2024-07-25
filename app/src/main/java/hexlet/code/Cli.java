package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String inString(String message) {
        System.out.println(message);
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        return answer;
    }
}
