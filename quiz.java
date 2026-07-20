import java.util.Scanner;

class Question {
    private int id;
    private String text;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    private String answer;   // stores the correct option TEXT, e.g. "Language"

    public Question(String text, String opt1, String opt2, String opt3, String opt4, String answer) {
        this.text = text;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.answer = answer;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getOpt1() { return opt1; }
    public void setOpt1(String opt1) { this.opt1 = opt1; }

    public String getOpt2() { return opt2; }
    public void setOpt2(String opt2) { this.opt2 = opt2; }

    public String getOpt3() { return opt3; }
    public void setOpt3(String opt3) { this.opt3 = opt3; }

    public String getOpt4() { return opt4; }
    public void setOpt4(String opt4) { this.opt4 = opt4; }

    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }

    // Returns the option text for a given choice number (1-4)
    public String getOptionByNumber(int choice) {
        switch (choice) {
            case 1: return opt1;
            case 2: return opt2;
            case 3: return opt3;
            case 4: return opt4;
            default: return null;
        }
    }

    @Override
    public String toString() {
        return text +
                "\n  1) " + opt1 +
                "\n  2) " + opt2 +
                "\n  3) " + opt3 +
                "\n  4) " + opt4;
    }
}

class QuestionService {

    Question[] questions = new Question[2];

    public QuestionService() {
        questions[0] = new Question(
                "What is Java?",
                "Language",
                "OS",
                "Browser",
                "Database",
                "Language");

        questions[1] = new Question(
                "2 + 2 = ?",
                "1",
                "2",
                "3",
                "4",
                "4");
    }

    // Runs the quiz: prints each question, reads input, checks answer, tracks score
    public void runQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            Question q = questions[i];

            System.out.println("\nQuestion " + (i + 1) + ": " + q);
            System.out.print("Enter your choice (1-4): ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, skipping this question.");
                continue;
            }
            String selectedOption = q.getOptionByNumber(choice);

            if (selectedOption != null && selectedOption.equalsIgnoreCase(q.getAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong. Correct answer was: " + q.getAnswer());
            }
        }
        System.out.println("\nQuiz finished! Your score: " + score + "/" + questions.length);
        scanner.close();
    }
}
public class quiz {
    public static void main(String[] args) {
        QuestionService service = new QuestionService();
        service.runQuiz();
    }
}