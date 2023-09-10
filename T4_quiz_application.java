import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    private String question;
    private List<String> options;
    private int correctOptionIndex;

    public Question(String question, List<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

class Quiz {
    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;
    private Scanner scanner;
    private Timer timer;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
        this.scanner = new Scanner(System.in);
        this.timer = new Timer();
    }

    public void start() {
        System.out.println("Welcome to the Quiz Game!");

        for (Question question : questions) {
            presentQuestion(question);
        }

        showResult();
    }

    private void presentQuestion(Question question) {
        System.out.println(question.getQuestion());

        List<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        System.out.print("Enter your answer (1-" + options.size() + "): ");
        int userChoice = scanner.nextInt();
        
        if (userChoice - 1 == question.getCorrectOptionIndex()) {
            System.out.println("Correct!\n");
            score++;
        } else {
            System.out.println("Incorrect!\n");
        }
    }

    private void showResult() {
        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + questions.size());

        scanner.close();
    }
}

public class T4_quiz_application {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();

        // Add questions with options and correct answer indices
        questions.add(new Question("What is the capital of France?", List.of("Berlin", "Paris", "Rome", "Madrid"), 1));
        questions.add(new Question("Which planet is known as the Red Planet?", List.of("Mars", "Venus", "Jupiter", "Mercury"), 0));

        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
}
