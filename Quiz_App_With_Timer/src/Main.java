import java.util.*;

public class Main {

    private static final int TIMER_DURATION = 30; // In seconds
    private final List<Question> ques;

    public Main(List<Question> questions) {
        this.ques = questions;
    }

    public void startQuiz() {
        int score = 0;
        int correctAns = 0;
        int incorrectAns = 0;

        for (Question question : ques) {
            long startTime = System.currentTimeMillis();

            System.out.println(question.getQuestionText());
            for (int i = 0; i < question.getOptions().size(); i++) {
                System.out.println((i + 1) + ". " + question.getOptions().get(i));
            }

            int userAnswer = getUserInput(question.getOptions().size());
            long endTime = System.currentTimeMillis();
            long timeTaken = (endTime - startTime) / 1000;

            if (userAnswer == question.getCorrectAnswer() && timeTaken <= TIMER_DURATION) {
                score++;
                correctAns++;
                System.out.println("Correct! You answered in " + timeTaken + " seconds.");
            } else {
                incorrectAns++;
                System.out.println("Incorrect. The correct answer is " + question.getCorrectOption());
            }
        }

        System.out.println("Quiz completed!");
        System.out.println("Score: " + score + "/" + ques.size());
        System.out.println("Correct answers: " + correctAns);
        System.out.println("Incorrect answers: " + incorrectAns);
    }

    private int getUserInput(int optionsCount) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your answer (1-" + optionsCount + "): ");
            String input = scanner.nextLine();

            try {
                int answer = Integer.parseInt(input);
                if (answer >= 1 && answer <= optionsCount) {
                    return answer;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and " + optionsCount);
            }
        }
    }

    public static void main(String[] args) {
        // Add your quiz questions here
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("PM of India?", Arrays.asList("Joe Biden", "Narendra Modi", "Yogi Adityanath"), 2));
        questions.add(new Question("What is the capital of France?", Arrays.asList("Rome", "London", "Paris"), 3));
        questions.add(new Question("What is the largest continent?", Arrays.asList("Asia", "Africa", "North America"), 1));

        Main quiz = new Main(questions);
        quiz.startQuiz();
    }
}

class Question {
    private final String questionText;
    private final List<String> options;
    private final int correctAnswer;

    public Question(String questionText, List<String> options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public String getCorrectOption() {
        return options.get(correctAnswer);
    }
}