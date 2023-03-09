package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Even {
    private static final int RANDOM_BOUND = 100;

    private static final String GAME_RULES = "Answer 'yes' if number is even, otherwise answer 'no'";

    public static void startGame() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][2];

        for (var i = 0; i < Engine.GAME_ROUNDS; i++) {
            Random random = new Random();
            var number = random.nextInt(RANDOM_BOUND) + 1;

            gameData[i][0] = String.valueOf(number);
            gameData[i][1] = isEven(number) ? "yes" : "no";
        }
        Engine.engineGame(gameData, GAME_RULES);
    }

    public static boolean isEven(final int number) {
        return number % 2 == 0;
    }
}
