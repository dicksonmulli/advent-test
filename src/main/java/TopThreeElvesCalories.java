import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TopThreeElvesCalories {

    public static void main(String[] args) {
        int totalTopThreeCalories = calculateTotalTopThreeCalories();

        // Ans: 203002
        System.out.println("The top three Elves are carrying a total of " + totalTopThreeCalories + " Calories.");
    }

    private static int calculateTotalTopThreeCalories() {
        Scanner scanner = new Scanner(System.in);

        PriorityQueue<Integer> allElvesCaloriesQueue = new PriorityQueue<>(Comparator.reverseOrder());

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

                allElvesCaloriesQueue.add(currentElfCalories);

                // Reset Calories
                currentElfCalories = 0;
            } else {
                consecutiveEmptyLines = 0;

                int calories = Integer.parseInt(lineInput);
                currentElfCalories += calories;
            }
        }

        int totalTopThreeCalories = 0;

        for (int i = 0; i < 3 && !allElvesCaloriesQueue.isEmpty(); i++) {
            totalTopThreeCalories += allElvesCaloriesQueue.poll();
        }
        return totalTopThreeCalories;
    }
}
