package tvseriesapp;

import java.util.ArrayList;
import java.util.Scanner;

//Main application to manage TV series
public class Menu {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Series> seriesList = new ArrayList<>();

        while (true) {

            System.out.println();
            System.out.println("LATEST SERIES - 2025");
            System.out.println("*************************************");
            System.out.println("Enter (1) to launch menu or any other key to exit");
            String startChoice = scanner.nextLine();

            if (!startChoice.equals("1")) {
                System.out.println("Exiting application. Goodbye!");
                break;
            }

            System.out.println();
            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a new series.");
            System.out.println("(3) Update series age restriction.");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application.");
            System.out.println();
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {

                //Capture a new series
                case 1:

                    System.out.println("CAPTURE A NEW SERIES");
                    System.out.println("****************************");

                    System.out.print("Enter the series id: ");
                    int seriesID = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter the series name: ");
                    String title = scanner.nextLine();

                    //Age restriction validation loop
                    int ageRestriction;
                    while (true) {
                        System.out.print("Enter the series age restriction: ");
                        String ageInput = scanner.nextLine();

                        try {
                            ageRestriction = Integer.parseInt(ageInput);
                            if (ageRestriction >= 2 && ageRestriction <= 18) {
                                break; // valid input
                            } else {
                                System.out.println("You have entered an incorrect series age!!!");
                                System.out.print("Please re-enter the series age >> ");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("You have entered an incorrect series age!!!");
                            System.out.print("Please re-enter the series age >> ");
                        }
                    }

                    System.out.print("Enter the number of episodes for " + title + ": ");
                    int episodes = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();

                    seriesList.add(new Series(seriesID, title, episodes, ageRestriction, genre));
                    System.out.println("Series processed successfully!!!");
                    break;

                //Search for a series by ID
                case 2:

                    System.out.print("Enter series ID to search: ");
                    int searchID = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;

                    for (Series s : seriesList) {
                        if (s.getSeriesID() == searchID) {
                            System.out.println(s.getSeriesInfo());
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Series not found.");
                    }
                    break;

//Consulted ChatGPT for case 3 and case 4
                //Update series episodes by ID
                case 3:

                    System.out.print("Enter series ID to update: ");
                    int updateID = scanner.nextInt();
                    scanner.nextLine();
                    boolean updated = false;

                    for (int i = 0; i < seriesList.size(); i++) {
                        if (seriesList.get(i).getSeriesID() == updateID) {
                            System.out.print("Enter new episode count: ");
                            int newEpisodes = scanner.nextInt();
                            scanner.nextLine();

                            Series updatedSeries = seriesList.get(i).updateEpisodes(newEpisodes);
                            seriesList.set(i, updatedSeries);

                            System.out.println("Episodes updated successfully!");
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Series not found.");
                    }
                    break;

                //Delete series by ID
                case 4:

                    System.out.print("Enter series ID to delete: ");
                    int deleteID = scanner.nextInt();
                    scanner.nextLine();
                    boolean deleted = false;

                    for (int i = 0; i < seriesList.size(); i++) {
                        if (seriesList.get(i).getSeriesID() == deleteID) {
                            seriesList.remove(i);
                            deleted = true;
                            break;
                        }
                    }

                    if (deleted) {
                        System.out.println("Series deleted successfully!");
                    } else {
                        System.out.println("Series not found.");
                    }
                    break;

                //Print series report
                case 5:

                    System.out.println("\n--- SERIES REPORT ---");
                    if (seriesList.isEmpty()) {
                        System.out.println("No series available.");
                    } else {
                        for (Series s : seriesList) {
                            System.out.println(s.getSeriesInfo());
                        }
                    }
                    break;

                //Exit
                case 6:

                    System.out.println("Exiting application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}