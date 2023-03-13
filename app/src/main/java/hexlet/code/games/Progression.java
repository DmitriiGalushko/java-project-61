package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    private static final int RANDOM_START = 0;
    private static final int FIRST_NUMBER_BOUND = 100;
    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 10;
    private static final int MAX_PROGRESSION_STEP = 10;
    private static final String GAME_RULES = "What number is missing in the progression?";

    public static void startGame() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][2];

        for (var i = 0; i < Engine.GAME_ROUNDS; i++) {
            var first = Utils.generateNumber(RANDOM_START, FIRST_NUMBER_BOUND);
            var step = Utils.generateNumber(RANDOM_START, MAX_PROGRESSION_STEP);
            var length = Utils.generateNumber(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
            var index = Utils.generateNumber(RANDOM_START, length - 1);

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
}
