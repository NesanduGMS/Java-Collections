import java.util.LinkedHashSet;
import java.util.Random;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        long timetoAdd = 0;
        long timetoContain = 0;
        long timetoRemove = 0;
        long timetoClear = 0;

        for (int j = 0; j < 100; j++) {
            // Create a LinkedHashSet to store random numbers
            LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

            // Create a Random object
            Random random = new Random();

            // Add random numbers to the LinkedHashSet until it contains exactly 100000 elements
            while (linkedHashSet.size() < 100000) {
                int randomNumber = random.nextInt(100_000); // Generates a random integer
                linkedHashSet.add(randomNumber);   // Add the random number to the LinkedHashSet
            }

            // Timing for adding a new random number
            long startTimeAdd = System.nanoTime();
            int newRandomNumber = random.nextInt(100_000);
            linkedHashSet.add(newRandomNumber);
            long endTimeAdd = System.nanoTime();
            timetoAdd += endTimeAdd - startTimeAdd;

            // Timing for checking if the new random number is present
            long startTimeContain = System.nanoTime();
            boolean isPresent = linkedHashSet.contains(newRandomNumber);
            long endTimeContain = System.nanoTime();
            timetoContain += endTimeContain - startTimeContain;

            // Timing for removing the new random number
            if (isPresent) {
                long startTimeRemove = System.nanoTime();
                linkedHashSet.remove(newRandomNumber);
                long endTimeRemove = System.nanoTime();
                timetoRemove += endTimeRemove - startTimeRemove;
            }

            // Timing for clearing the LinkedHashSet
            long startTimeClear = System.nanoTime();
            linkedHashSet.clear();
            long endTimeClear = System.nanoTime();
            timetoClear += endTimeClear - startTimeClear;
        }

        System.out.println("Average time to add: " + (timetoAdd / 100) + " nanoseconds");
        System.out.println("Average time to contain: " + (timetoContain / 100) + " nanoseconds");
        System.out.println("Average time to remove: " + (timetoRemove / 100) + " nanoseconds");
        System.out.println("Average time to clear: " + (timetoClear / 100) + " nanoseconds");
    }
}