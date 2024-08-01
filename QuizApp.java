import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Quiz {
    private String question;
    private String[] options;
    private int correctAnswer;

    public Quiz(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

class QuizApp {
    private Quiz[] quizzes;
    private int score;
    private Scanner scanner;

    public QuizApp(Quiz[] quizzes) {
        this.quizzes = quizzes;
        this.score = 0;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        for (int i = 0; i < quizzes.length; i++) {
            boolean isAnswered = displayQuestion(quizzes[i], i + 1);
            if (!isAnswered) {
                System.out.println("Time is up! Moving to the next question.");
            }
        }
        displayResult();
    }

    private boolean displayQuestion(Quiz quiz, int questionNumber) {
        System.out.println("Question " + questionNumber + ": " + quiz.getQuestion());
        String[] options = quiz.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        final boolean[] isAnswered = {false};
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!isAnswered[0]) {
                    isAnswered[0] = true;
                }
            }
        }, 10000); // 10 seconds timer

        while (!isAnswered[0]) {
            System.out.print("Select an option (1-" + options.length + "): ");
            int answer = scanner.nextInt();
            if (answer >= 1 && answer <= options.length) {
                isAnswered[0] = true;
                if (answer == quiz.getCorrectAnswer()) {
                    score++;
                }
                timer.cancel();
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        return isAnswered[0];
    }

    private void displayResult() {
        System.out.println("Quiz Over! Your final score is: " + score);
        for (int i = 0; i < quizzes.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + quizzes[i].getQuestion());
            System.out.println("Correct answer: " + quizzes[i].getOptions()[quizzes[i].getCorrectAnswer() - 1]);
        }
    }

    public static void main(String[] args) {
        Quiz[] quizzes = new Quiz[] {
            new Quiz("What is the capital of France?", new String[] {"Berlin", "Madrid", "Paris", "Rome"}, 3),
            new Quiz("What is 5 + 3?", new String[] {"5", "8", "9", "10"}, 2),
            new Quiz("Who wrote 'To Kill a Mockingbird'?", new String[] {"Harper Lee", "Mark Twain", "J.K. Rowling", "Ernest Hemingway"}, 1),
            new Quiz("What is the largest planet in our solar system?", new String[] {"Earth", "Jupiter", "Saturn", "Mars"}, 2),
            new Quiz("What is the chemical symbol for water?", new String[] {"O2", "CO2", "H2O", "H2SO4"}, 3)
        };
        QuizApp quizApp = new QuizApp(quizzes);
        quizApp.start();
    }
}
