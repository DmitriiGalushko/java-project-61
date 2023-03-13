package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    private static final int RANDOM_START = 0;
    private static final int RANDOM_BOUND = 100;
    private static final String GAME_RULES = "What is the result of the expression?";

    public static void startGame() {
        String[][] gameData = new String[Engine.GAME_ROUNDS][2];

        for (var i = 0; i < Engine.GAME_ROUNDS; i++) {
            var firstNumber = Utils.generateNumber(RANDOM_START, RANDOM_BOUND);
            var secondNumber = Utils.generateNumber(RANDOM_START, RANDOM_BOUND);
            String[] operators = {"+", "-", "*"};
            var operatorBound = operators.length;
            var operatorIndex = Utils.generateNumber(RANDOM_START, operatorBound);
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
