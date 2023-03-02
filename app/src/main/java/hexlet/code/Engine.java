package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int CORRECT_ANSWERS = 3;
    private static final int OPERAND_AMOUNT = 2;
    private static final int RANDOM_RANGE = 100;
    public static void engineOfTheGames() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        var sum = 0;
    }
}
