package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;

public class Calc extends Engine {
    private static final int RANDOM_RANGE = 100;

    public Calc(String name) {
        super(name);
    }

    public final void gameRules() {
        System.out.println("What is the result of the expression?");
    }

    public final boolean gameRound() {
        Random random = new Random();
        var firstNumber = random.nextInt(RANDOM_RANGE) + 1;
        var secondNumber = random.nextInt(RANDOM_RANGE) + 1;
        String[] operators = {"+", "-", "*"};
        var operandRange = operators.length;
        var i = random.nextInt(operandRange);
        System.out.println("Question: " + firstNumber + " "
                + operators[i] + " " + secondNumber);
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.next().trim().toLowerCase();
        System.out.println("Your answer: "  + userAnswer);
        return checkAnswer(userAnswer, Integer.toString(getCorrectAnswer(firstNumber, secondNumber, operators[i])));
    }

    private int getCorrectAnswer(int firstNumber, int secondNumber, String operator) {
            return switch (operator) {
                case "+" -> firstNumber + secondNumber;
                case "-" -> firstNumber - secondNumber;
                default -> firstNumber * secondNumber;
            };
    }
}
