package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        String userChoice = scanner.next();
        System.out.println("Your choice: " + userChoice);

        switch (userChoice) {
            case "0" -> System.exit(0);
            case "1" -> Cli.greet();
            case "2" -> new Even(Cli.greet()).gameEngine();
            case "3" -> new Calc(Cli.greet()).gameEngine();
            case "4" -> new GCD(Cli.greet()).gameEngine();
            case "5" -> new Progression(Cli.greet()).gameEngine();
            case "6" -> new Prime(Cli.greet()).gameEngine();
            default -> System.out.println("Wrong command! Please try again.");
        }

        scanner.close();
    }
}
