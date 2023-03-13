package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    private static final int RANDOM_START = 0;
    private static final int RANDOM_BOUND = 100;
    private static final String GAME_RULES = "Find the greatest common divisor of given numbers.";

    public static void startGame() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][2];

        for (var i = 0; i < Engine.GAME_ROUNDS; i++) {
            int correctAnswer;
            var firstNumber = Utils.generateNumber(RANDOM_START, RANDOM_BOUND);
            var secondNumber = Utils.generateNumber(RANDOM_START, RANDOM_BOUND);

            gameData[i][0] = firstNumber + " " + secondNumber;
            correctAnswer = getGcd(firstNumber, secondNumber);
            gameData[i][1] = String.valueOf(correctAnswer);
        }

        Engine.engineGame(gameData, GAME_RULES);
    }

    private static int getGcd(int firstNumber, int secondNumber) {
        while (firstNumber != 0 && secondNumber != 0) {
            if (firstNumber > secondNumber) {
                firstNumber %= secondNumber;
            } else {
                secondNumber %= firstNumber;
            }
        }
        return firstNumber + secondNumber;
    }
 }
