import java.util.HashSet;
import java.util.Random;

public class HashSetTest {
    public static void main(String[] args) {
        long timetoAdd = 0;
        long timetoContain = 0;
        long timetoRemove = 0;
        long timetoClear = 0;

        for (int j = 0; j < 100; j++) {
            // Create a HashSet to store random numbers
            HashSet<Integer> hashSet = new HashSet<>();

            // Create a Random object
            Random random = new Random();

            // Add 100,000 random numbers to the HashSet
            while(hashSet.size()<100000){
                int randomNumber = random.nextInt(100_000); // Generates a random integer
                hashSet.add(randomNumber);   // Add the random number to the HashSet

            }


            // Timing for adding a new random number
            long startTimeAdd = System.nanoTime();
            int newRandomNumber = random.nextInt(100_000);
            hashSet.add(newRandomNumber);
            long endTimeAdd = System.nanoTime();
            timetoAdd += endTimeAdd - startTimeAdd;

            // Timing for checking if the new random number is present
            long startTimeContain = System.nanoTime();
            boolean isPresent = hashSet.contains(newRandomNumber);
            long endTimeContain = System.nanoTime();
            timetoContain += endTimeContain - startTimeContain;

            // Timing for removing the new random number
            if (isPresent) {
                long startTimeRemove = System.nanoTime();
                hashSet.remove(newRandomNumber);
                long endTimeRemove = System.nanoTime();
                timetoRemove += endTimeRemove - startTimeRemove;
            }

            // Timing for clearing the HashSet
            long startTimeClear = System.nanoTime();
            hashSet.clear();
            long endTimeClear = System.nanoTime();
            timetoClear += endTimeClear - startTimeClear;
        }

        System.out.println("Average time to add: " + (timetoAdd / 100) + " nanoseconds");
        System.out.println("Average time to contain: " + (timetoContain / 100) + " nanoseconds");
        System.out.println("Average time to remove: " + (timetoRemove / 100) + " nanoseconds");
        System.out.println("Average time to clear: " + (timetoClear / 100) + " nanoseconds");
    }
}




