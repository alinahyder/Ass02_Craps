import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            boolean continuePlaying = true;

            while (continuePlaying) {
                int die1 = random.nextInt(6) + 1;
                int die2 = random.nextInt(6) + 1;
                int sum = die1 + die2;

                System.out.printf("Initial roll: Die1: %d, Die2: %d, Sum: %d%n", die1, die2, sum);

                if (sum == 2 || sum == 3 || sum == 12) {
                    System.out.println("Craps! You lose.");
                } else if (sum == 7 || sum == 11) {
                    System.out.println("Natural! You win.");
                } else {
                    int point = sum;
                    System.out.printf("The point is now: %d%n", point);

                    boolean pointMade = false;
                    while (!pointMade) {
                        die1 = random.nextInt(6) + 1;
                        die2 = random.nextInt(6) + 1;
                        sum = die1 + die2;

                        System.out.printf("Trying for point: Die1: %d, Die2: %d, Sum: %d%n", die1, die2, sum);

                        if (sum == point) {
                            System.out.println("Made the point! You win.");
                            pointMade = true;
                        } else if (sum == 7) {
                            System.out.println("Rolled a 7! You lose.");
                            pointMade = true;
                        }
                    }
                }

                boolean validResponse = false;
                while (!validResponse) {
                    System.out.println("Do you want to play again? (yes/no)");
                    String userInput = scanner.nextLine().trim().toLowerCase();

                    if (userInput.equals("yes")) {
                        System.out.println("You chose to play again!");
                        validResponse = true;
                        continuePlaying = true;
                    } else if (userInput.equals("no")) {
                        System.out.println("Good Game!");
                        validResponse = true;
                        continuePlaying = false;
                    } else {
                        System.out.println("Invalid response. Please enter 'yes' or 'no'.");
                    }
                }
            }

            scanner.close();

    }
}