package quizapp;

public class TrueFalseQuestion extends Question {

    public TrueFalseQuestion(String text, String answer) {
        super(text, answer);
    }

    @Override
    public void display() {
        System.out.println(getText() + " (True/False)");
    }

    @Override
    public boolean checkAnswer(String answer) {
        return getAnswer().equalsIgnoreCase(answer.trim());
    }
}