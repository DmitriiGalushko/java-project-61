package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;


public class Prime {
    private static final int RANDOM_BOUND = 1000;

    private static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startGame() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][2];

        for (var i = 0; i < Engine.GAME_ROUNDS; i++) {
            Random random = new Random();
            var number = random.nextInt(RANDOM_BOUND) + 1;

            gameData[i][0] = String.valueOf(number);
            gameData[i][1] = isPrime(number) ? "yes" : "no";
        }
        Engine.engineGame(gameData, GAME_RULES);
    }

    public static boolean isPrime(int number) {
        for (var i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
