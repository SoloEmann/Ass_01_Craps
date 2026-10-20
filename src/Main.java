import java.util.Random;
import java.util.Scanner;

class Craps {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        String again = "Y";

        while (again.equalsIgnoreCase("Y")) {

            // First roll
            int die1 = rand.nextInt(6) + 1;
            int die2 = rand.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("Die 1: " + die1);
            System.out.println("Die 2: " + die2);
            System.out.println("Sum: " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose!");
            }
            else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win!");
            }
            else {
                int point = sum;
                System.out.println("Point is: " + point);

                // Keep rolling until win or loss
                while (sum != point || sum == point) {
                    die1 = rand.nextInt(6) + 1;
                    die2 = rand.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.println("Die 1: " + die1);
                    System.out.println("Die 2: " + die2);
                    System.out.println("Sum: " + sum);

                    if (sum == point) {
                        System.out.println("Made point! You win!");
                        break;
                    }
                    else if (sum == 7) {
                        System.out.println("Got a seven! You lose!");
                        break;
                    }
                    else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            System.out.print("Play again? (Y/N): ");
            again = input.nextLine();
        }

        input.close();
    }
}
