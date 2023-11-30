import java.util.Scanner;

public class MaxElfCalories {
    public static void main(String[] args) {
        int maxCalories = calculateMaxCalories();

        //  Ans: 70369
        System.out.println("The Elf carrying max Calories is carrying: " + maxCalories + " Calories.");
    }

    private static int calculateMaxCalories() {
        Scanner scanner = new Scanner(System.in);

        int maxCalories = 0;
        int currentElfCalories = 0;
        int consecutiveEmptyLines = 0;

        while (scanner.hasNextLine() && consecutiveEmptyLines < 2) {
            String lineInput = scanner.nextLine();

            if (lineInput.isEmpty()) {
                consecutiveEmptyLines++;

                if (consecutiveEmptyLines == 2) {
                    // Exit the while loop if user enters two consecutive empty lines
                    break;
                }

                maxCalories = Math.max(maxCalories, currentElfCalories);
                currentElfCalories = 0;
            } else {
                consecutiveEmptyLines = 0;

                int calories = Integer.parseInt(lineInput);
                currentElfCalories += calories;
            }
        }
        return maxCalories;
    }
}
