package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    private static final int RANDOM_START = 0;
    private static final int RANDOM_BOUND = 1000;
    private static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startGame() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][2];

        for (var i = 0; i < Engine.GAME_ROUNDS; i++) {
            var number = Utils.generateNumber(RANDOM_START, RANDOM_BOUND);

            gameData[i][0] = String.valueOf(number);
            gameData[i][1] = isPrime(number) ? "yes" : "no";
        }
        Engine.engineGame(gameData, GAME_RULES);
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (var i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
