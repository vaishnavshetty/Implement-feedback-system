import java.util.ArrayList;
import java.util.Scanner;

class Feedback {
    String userName;
    String itemName;
    int rating;
    String comments;

    // Constructor
    Feedback(String userName, String itemName, int rating, String comments) {
        this.userName = userName;
        this.itemName = itemName;
        this.rating = rating;
        this.comments = comments;
    }

    // Display feedback details
    void displayFeedback() {
        System.out.println("------------------------------");
        System.out.println("User Name : " + userName);
        System.out.println("Product/Service : " + itemName);
        System.out.println("Rating : " + rating + "/5");
        System.out.println("Comments : " + comments);
    }
}

public class FeedbackSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Feedback> feedbackList = new ArrayList<>();

        int choice;
        do {
            System.out.println("\n===== Feedback System =====");
            System.out.println("1. Submit Feedback");
            System.out.println("2. Display All Feedback");
            System.out.println("3. Show Average Rating");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter User Name: ");
                    String userName = sc.nextLine();

                    System.out.print("Enter Product/Service Name: ");
                    String itemName = sc.nextLine();

                    System.out.print("Enter Rating (1 to 5): ");
                    int rating = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Comments: ");
                    String comments = sc.nextLine();

                    Feedback fb = new Feedback(userName, itemName, rating, comments);
                    feedbackList.add(fb);

                    System.out.println("Feedback submitted successfully!");
                    break;

                case 2:
                    if (feedbackList.isEmpty()) {
                        System.out.println("No feedback records found.");
                    } else {
                        System.out.println("\n--- Feedback Records ---");
                        for (Feedback f : feedbackList) {
                            f.displayFeedback();
                        }
                    }
                    break;

                case 3:
                    if (feedbackList.isEmpty()) {
                        System.out.println("No ratings available.");
                    } else {
                        int total = 0;
                        for (Feedback f : feedbackList) {
                            total += f.rating;
                        }
                        double average = (double) total / feedbackList.size();
                        System.out.println("Average Rating: " + average + "/5");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Feedback System...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
