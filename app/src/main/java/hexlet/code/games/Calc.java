package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Calc {

    private static final int RANDOM_BOUND = 100;

    private static final String GAME_RULES = "What is the result of the expression?";

    public static void startGame() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][2];

        for (var i = 0; i < Engine.GAME_ROUNDS; i++) {
            Random random = new Random();
            var firstNumber = random.nextInt(RANDOM_BOUND) + 1;
            var secondNumber = random.nextInt(RANDOM_BOUND) + 1;
            String[] operators = {"+", "-", "*"};
            var operatorBound = operators.length;
            var operatorIndex = random.nextInt(operatorBound);
            var randomOperator = operators[operatorIndex];

            gameData[i][0] = firstNumber + " " + randomOperator + " " + secondNumber;
            gameData[i][1] = getCorrectAnswer(firstNumber, randomOperator, secondNumber);
        }
        Engine.engineGame(gameData, GAME_RULES);
    }

    public static String getCorrectAnswer(int firstNumber, String operator, int secondNumber) {
        int result = switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            default -> throw new Error("Unknown operation: " + operator + "!");
        };

        return String.valueOf(result);
    }
}
