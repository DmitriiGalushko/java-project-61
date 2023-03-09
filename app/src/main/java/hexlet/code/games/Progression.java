package hexlet.code.games;

import hexlet.code.Engine;
 import java.util.Random;

public class Progression extends Engine {
    private static final int FIRST_NUMBER_RANGE = 100;

    private static final int MIN_PROGRESSION_LENGTH = 5;

    private static final int MAX_PROGRESSION_LENGTH = 10;

    private static final int MAX_PROGRESSION_STEP = 10;

    private static final String GAME_RULES = "What number is missing in the progression?";

    public static void startGame() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][2];

        for (var i = 0; i < Engine.GAME_ROUNDS; i++) {
            Random random = new Random();
            var first = random.nextInt(FIRST_NUMBER_RANGE) + 1;
            var step = random.nextInt(MAX_PROGRESSION_STEP) + 1;
            var index = random.nextInt(MAX_PROGRESSION_LENGTH - 1);
            var length = getRandomNumber(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH + 1);

            String[] progression = makeProgression(first, step, length);
            gameData[i][1] = progression[index];
            progression[index] = "..";
            gameData[i][0] = String.join(" ", progression);
        }

        Engine.engineGame(gameData, GAME_RULES);
    }

    public static String[] makeProgression(int first, int step, int length) {
        String[] progression = new String[length];
        for (var i = 0; i < length; i++) {
            progression[i] = Integer.toString(first + i * step);
        }

        return progression;
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
