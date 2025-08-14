package quizapp;

import java.util.ArrayList;

public class ChoiceQuestion extends Question {

    private ArrayList<String> choices = new ArrayList<>();

    public ChoiceQuestion(String text) {
        super(text, ""); //Answer will be set later when correct choice is added
    }

    public void addChoice(String choice, boolean correct) {
        choices.add(choice);
        if (correct) {

            //Set the correct answer to the index (starting from 1)
            try {
                java.lang.reflect.Field answerField = Question.class.getDeclaredField("answer");
                answerField.setAccessible(true);
                answerField.set(this, String.valueOf(choices.size()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void display() {
        System.out.println(getText());
        for (int i = 0; i < choices.size(); i++) {
            System.out.println((i + 1) + ": " + choices.get(i));
        }
    }

    @Override
    public boolean checkAnswer(String answer) {
        return getAnswer().equals(answer.trim());
    }
}