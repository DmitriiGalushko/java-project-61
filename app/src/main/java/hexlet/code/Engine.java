package hexlet.code;

public abstract class Engine {

    private static final int CORRECT_ANSWERS = 3;

    private final String userName;

    private int correctAnswersCount = 0;

    public Engine(String name) {
        this.userName = name;
    }

     public final void gameEngine() {
        gameRules();
        roundCheck();
        gameEnd();
    }

    public abstract void gameRules();

    public abstract boolean gameRound();

    private void roundCheck() {
        while (correctAnswersCount < CORRECT_ANSWERS) {
            boolean roundResult = gameRound();
            if (!roundResult) {
               break;
           }
       }
   }

    public final boolean checkAnswer(String userAnswer, String correctAnswer) {
        if (userAnswer != null && userAnswer.equals(correctAnswer)) {
            correctAnswersCount++;
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                    + correctAnswer + "'.\n" + "Let's try again, " + userName + "!");
            return false;
        }
    }

    private void gameEnd() {
        if (correctAnswersCount == CORRECT_ANSWERS) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
