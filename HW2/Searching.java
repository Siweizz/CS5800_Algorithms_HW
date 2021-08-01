package ca.neu;
import edu.princeton.cs.algs4.Stopwatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Homework - Searching
 * Find the selected number in the list.
 * The only method you can change is the search() method.
 * You can add additional methods if needed, without changing the load() and test() methods.
 */
public class Searching {

    protected List list = new ArrayList<Integer>();
    private Random random = new Random();

    /**
     * Loading the text files with double numbers
     */
    protected void load() {
        try (Stream<String> stream = Files.lines(Paths.get("numbers.txt"))) {
            stream.forEach(x -> list.add(Integer.parseInt(x)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Testing of your solution, using 100 shuffled examples
     *
     * @return execution time
     */
    protected double test() {
        Stopwatch watch = new Stopwatch();
        for (int i = 0; i < 100; i++) {
            Collections.shuffle(list, new Random(100));
            search(list, (Integer) list.get(random.nextInt(list.size())));
        }
        return watch.elapsedTime();
    }

    /**
     * Searching method - add your code in here
     *
     * @param list - list to be sorted and the searched
     */
    private void search(List list, int index) {
        Collections.sort(list);

        //Collections.binarySearch(list, index);
        exponentialSearch(list, index);
    }
    // /* ----------------------------------------------------------------------------

    private int exponentialSearch(List<Integer> list, int index) {
        int n = list.size();
        if (list.get(0) == index)
            return 0;
        int i = 1;
        while (i < n && list.get(i) <= index)
            i = i * 2;
        return binarySearch(list, i / 2, Math.min(i, n), index);
    }

    private int binarySearch(List<Integer> list, int low, int high, int index) {

        while (low <= high) {

            int mid = low + (high - low) / 2;
            if (index < list.get(mid)) high = mid - 1;
            else if (index > list.get(mid)) low = mid + 1;
            else return mid;
        }
        return -1;
    }

}