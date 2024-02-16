import java.util.Random;
import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random random = new Random();

        for (int i = 0; i < 100000; i++){
            linkedList.add(i);
        }

        long addTime = 0;
        long checkingTime = 0;
        long removingTime = 0;
        long clearingTime = 0;

        for (int i = 100000; i < 100100; i++){
            long start = System.nanoTime();
            linkedList.add(i);
            long end = System.nanoTime();
            addTime += (end - start);
        }

        for (int i = 0; i < 100; i++){
            int value = random.nextInt(99999) + 50000;
            long start = System.nanoTime();
            boolean contains = linkedList.contains(value);
            long end = System.nanoTime();
            checkingTime += (end - start);
        }

        for (int i = 0; i < 100; i++){
            Integer value = random.nextInt(99999) + 50000;
            long start = System.nanoTime();
            linkedList.remove(value);
            long end = System.nanoTime();
            removingTime += (end - start);
        }

        for (int i = 0; i < 100; i++){
            long start = System.nanoTime();
            linkedList.clear();
            long end = System.nanoTime();
            clearingTime += (end - start);

            for (int j = 0; j < 100000; j++){
                linkedList.add(j);
            }
        }

        System.out.println("Add an element -> "+ addTime/100 + " nanoseconds");
        System.out.println("Find an element -> "+ checkingTime/100 + " nanoseconds");
        System.out.println("Remove an element -> "+ removingTime/100 + " nanoseconds");
        System.out.println("Clear all the elements -> "+ clearingTime/100 + " nanoseconds");

    }
}
