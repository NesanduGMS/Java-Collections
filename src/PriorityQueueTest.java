import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueTest {
    public static void main(String[] args) {
        long timetoAdd = 0;
        long timetoContain = 0;
        long timetoremove = 0;
        long timetoclear = 0;

        for (int j = 0; j < 100; j++) {
            // Create a PriorityQueue to store random numbers
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

            // Create a Random object
            Random random = new Random();

            // Add 100,000 random numbers to the PriorityQueue
            for (int i = 0; i < 100000; i++) {
                int randomNumber = random.nextInt(100_000); // Generates a random integer
                priorityQueue.offer(randomNumber);   // Add the random number to the PriorityQueue
            }

            // Timing for adding a new random number
            long startTimeAdd = System.nanoTime();
            int newRandomNumber = random.nextInt(100_000);
            priorityQueue.add(newRandomNumber);
            long endTimeAdd = System.nanoTime();
            timetoAdd += endTimeAdd - startTimeAdd;

            // Timing for checking if the new random number is present
            long startTimeContain = System.nanoTime();
            boolean isPresent = priorityQueue.contains(newRandomNumber);
            long endTimeContain = System.nanoTime();
            timetoContain += endTimeContain - startTimeContain;

            // Timing for removing the new random number
            if (isPresent) {
                long startTimeRemove = System.nanoTime();
                priorityQueue.remove(newRandomNumber);
                long endTimeRemove = System.nanoTime();
                timetoremove += endTimeRemove - startTimeRemove;
            }

            // Timing for clearing the PriorityQueue
            long startTimeClear = System.nanoTime();
            priorityQueue.clear();
            long endTimeClear = System.nanoTime();
            timetoclear += endTimeClear - startTimeClear;
        }

        System.out.println("Average time to add: " + (timetoAdd / 100) + " nanoseconds");
        System.out.println("Average time to contain: " + (timetoContain / 100) + " nanoseconds");
        System.out.println("Average time to remove: " + (timetoremove / 100) + " nanoseconds");
        System.out.println("Average time to clear: " + (timetoclear / 100) + " nanoseconds");
    }
}