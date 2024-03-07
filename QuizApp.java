import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctAnswer;

    public QuizQuestion(String question, List<String> options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

public class QuizApp {
    private static int score = 0;
    private static int currentQuestionIndex = 0;

    private static List<QuizQuestion> quizQuestions = new ArrayList<>();

    public static void main(String[] args) {
        initializeQuizQuestions();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                displayResult();
                System.exit(0);
            }
        }, 60000); // 60 seconds timer for each question

        Scanner scanner = new Scanner(System.in);

        while (currentQuestionIndex < quizQuestions.size()) {
            QuizQuestion currentQuestion = quizQuestions.get(currentQuestionIndex);
            System.out.println("Question " + (currentQuestionIndex + 1) + ": " + currentQuestion.getQuestion());
            List<String> options = currentQuestion.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            System.out.print("Enter your choice: ");
            int userChoice = scanner.nextInt();

            if (userChoice == currentQuestion.getCorrectAnswer()) {
                score++;
            }

            currentQuestionIndex++;
        }

        displayResult();
        timer.cancel();
        scanner.close();
    }

    private static void initializeQuizQuestions() {
        List<String> options1 = new ArrayList<>();
        options1.add("A. Java");
        options1.add("B. Python");
        options1.add("C. C++");
        options1.add("D. JavaScript");
        quizQuestions.add(new QuizQuestion("Which Language is used to do Android App Developement?", options1, 1));

        List<String> options2 = new ArrayList<>();
        options2.add("A. Navneet Dalal");
        options2.add("B. Guido van Rossum");
        options2.add("C. Dennis Ritchie");
        options2.add("D. James Gosling");
        quizQuestions.add(new QuizQuestion("Who is Founder of JAVA?", options2, 4));

        List<String> options3 = new ArrayList<>();
        options3.add("A. Navneet Dalal");
        options3.add("B. Guido van Rossum");
        options3.add("C. Dennis Ritchie");
        options3.add("D. James Gosling");  
        quizQuestions.add(new QuizQuestion("Who is Founder of Python?", options3, 2));

        List<String> options4 = new ArrayList<>();
        options4.add("A. Char");
        options4.add("B. Boolean");
        options4.add("C. Float");
        options4.add("D. Int");
        quizQuestions.add(new QuizQuestion("Which Datatype in java is to used to create variable that should store decimal value'?", options4, 3));

        List<String> options5 = new ArrayList<>();
        options5.add("A. = ");
        options5.add("B. <>");
        options5.add("C. ><");
        options5.add("D. ==");
        quizQuestions.add(new QuizQuestion("Which Operator is used to Compare two Values?", options5, 4));
    }

    private static void displayResult() {
        System.out.println("\nQuiz has ended!");
        System.out.println("Your score: " + score + " out of " + quizQuestions.size());
    }
}

