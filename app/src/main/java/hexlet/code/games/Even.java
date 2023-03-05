package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;

public class Even extends Engine {
    private static final int RANDOM_RANGE = 100;

    public Even(String name) {
        super(name);
    }

    public final void gameRules() {
        System.out.println("Answer 'yes' if number is even, otherwise answer 'no'");
    }

    public final boolean gameRound() {
        Random random = new Random();
        var number = random.nextInt(RANDOM_RANGE) + 1;
        System.out.println("Question: " + number);
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.next().trim().toLowerCase();
        return checkAnswer(userAnswer, getCorrectAnswer(number));
    }

    private String getCorrectAnswer(final int number) {
        return (number % 2 == 0) ? "yes" : "no";
    }
}
