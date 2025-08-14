package quizapp;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Question> Questions = new ArrayList<>();

        //True/False Questions
        Questions.add(new TrueFalseQuestion("The human heart has 4 chambers.", "True"));
        Questions.add(new TrueFalseQuestion("Plants produce oxygen during photosynthesis.", "True"));
        Questions.add(new TrueFalseQuestion("Bacteria are multicellular organisms.", "False"));

        //Multiple Choice Questions
        ChoiceQuestion Q1 = new ChoiceQuestion("Which organ filters blood in the human body?");
        Q1.addChoice("Lungs", false);
        Q1.addChoice("Kidneys", true);
        Q1.addChoice("Liver", false);
        Questions.add(Q1);

        ChoiceQuestion Q2 = new ChoiceQuestion("What is the largest organ in the human body?");
        Q2.addChoice("Skin", true);
        Q2.addChoice("Liver", false);
        Q2.addChoice("Heart", false);
        Questions.add(Q2);

        ChoiceQuestion Q3 = new ChoiceQuestion("Which gas do plants absorb from the atmosphere?");
        Q3.addChoice("Oxygen", false);
        Q3.addChoice("Carbon Dioxide", true);
        Q3.addChoice("Nitrogen", false);
        Questions.add(Q3);

        ChoiceQuestion Q4 = new ChoiceQuestion("Which blood cells help fight infections?");
        Q4.addChoice("Red Blood Cells", false);
        Q4.addChoice("White Blood Cells", true);
        Q4.addChoice("Platelets", false);
        Questions.add(Q4);

        ChoiceQuestion Q5 = new ChoiceQuestion("Where in the cell does photosynthesis occur?");
        Q5.addChoice("Mitochondria", false);
        Q5.addChoice("Chloroplasts", true);
        Q5.addChoice("Nucleus", false);
        Questions.add(Q5);

        ChoiceQuestion Q6 = new ChoiceQuestion("What is the powerhouse of the cell?");
        Q6.addChoice("Nucleus", false);
        Q6.addChoice("Mitochondria", true);
        Q6.addChoice("Ribosome", false);
        Questions.add(Q6);

        ChoiceQuestion Q7 = new ChoiceQuestion("Which vitamin is produced when skin is exposed to sunlight?");
        Q7.addChoice("Vitamin A", false);
        Q7.addChoice("Vitamin D", true);
        Q7.addChoice("Vitamin C", false);
        Questions.add(Q7);

        //Quiz loop
        int score = 0;
        for (Question Q : Questions) {
            Q.display();
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();
            if (Q.checkAnswer(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! Correct answer: " + Q.getAnswer());
            }
            System.out.println();
        }

        System.out.println("Your final score: " + score + "/" + Questions.size());
        scanner.close();
    }
}
