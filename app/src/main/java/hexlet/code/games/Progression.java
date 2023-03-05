package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Progression extends Engine {
    private static final int FIRST_NUMBER_RANGE = 100;

    private static final int PROGRESSION_LENGTH = 10;

    private static final int MAX_PROGRESSION_STEP = 10;

    private final int[] progression = new int[PROGRESSION_LENGTH];

    public Progression(String name) {
        super(name);
    }

    public final void gameRules() {
        System.out.println("What number is missing in the progression?");
    }

    public final boolean gameRound() {
        generateProgression();
        Random random = new Random();
        var index = random.nextInt(PROGRESSION_LENGTH);
        System.out.println("Question: " + hideProgressionNumber(index));
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.next().trim().toLowerCase();
        return checkAnswer(userAnswer,  Integer.toString(progression[index]));
    }

    private void generateProgression() {
        Random random = new Random();
        var firstNumber = random.nextInt(FIRST_NUMBER_RANGE) + 1;
        var step = random.nextInt(MAX_PROGRESSION_STEP) + 1;
        for (var i = 0; i < progression.length; i++) {
            progression[i] = firstNumber;
            firstNumber += step;
        }
    }

    private String hideProgressionNumber(int index) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i == index) {
                builder.append("..");
            } else {
                builder.append(progression[i]);
            }
            builder.append(" ");
        }
        return builder.toString();
    }
}
