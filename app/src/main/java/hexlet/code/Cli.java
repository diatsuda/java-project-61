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
            return 0;
        }
        return Integer.parseInt(response);
    }

    public static void say(String message) {
        System.out.println(message);
    }

    public static int random(int min, int max) {
        if (max < min) {
            int buffer = max;
            max = min;
            min = buffer;
        } else if (max == min) {
            return max;
        };

        max += 1;
        int rand = (int) (Math.random() * min + Math.random() * max);

        while (rand < min || rand > max) {
            if (rand < min) {
                rand += ((int) (Math.random()*10) * max%min);
            } else if (rand > max) {
                rand -= ((int) (Math.random()*10) * max%min);
            };
        };

        return rand;
    };

}
