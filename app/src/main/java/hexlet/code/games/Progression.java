package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Progression extends Engine {
    private static final int FIRST_NUMBER_RANGE = 100;

    private static final int MIN_PROGRESSION_LENGTH = 5;

    private static final int MAX_PROGRESSION_LENGTH = 10;

    private static final int MAX_PROGRESSION_STEP = 10;

    public Progression(String name) {
        super(name);
    }

    public final void gameRules() {
        System.out.println("What number is missing in the progression?");
    }

    private static String[] makeProgression(int first, int step, int length) {
        String[] progression = new String[length];
        for (var i = 0; i < length; i++) {
            progression[i] = Integer.toString(first + i * step);
        }

        return progression;
    }

    private int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

     public final boolean gameRound() {
        Random random = new Random();
        var first = random.nextInt(FIRST_NUMBER_RANGE) + 1;
        var step = random.nextInt(MAX_PROGRESSION_STEP) + 1;
        var index = random.nextInt(MAX_PROGRESSION_LENGTH - 1);
        var length = getRandomNumber(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH + 1);
        String[] progression = makeProgression(first, step, length);
        String answer = progression[index];
        progression[index] = "..";
        String question = String.join(" ", progression);
        System.out.println("Question: " + question);
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.next().trim().toLowerCase();
        return checkAnswer(userAnswer, answer);
    }
}
