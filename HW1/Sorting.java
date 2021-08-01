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
 * Homework - Sorting
 * Sort the list of doubles in the fastest possible way.
 * The only method you can change is the sort() method.
 * You can add additional methods if needed, without changing the load() and test() methods.
 */
public class Sorting {

    protected List list = new ArrayList<Double>();

    /**
     * Loading the text files with double numbers
     */
    protected void load() {
        try (Stream<String> stream = Files.lines(Paths.get("numbers.txt"))) {
            stream.forEach(x -> list.add(Double.parseDouble(x)));
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
            sort(list);
        }
        return watch.elapsedTime();
    }

    /**
     * Sorting method - add your code in here
     *
     * @param list - list to be sorted
     */
    private void sort(List list) {
        // use quick sort methods
        // Best case O(nlogn), average case O(nlogn), worst case O(n*n)

        quick_sort(list,0,list.size()-1);

        //Collections.sort(list);

    }

    private void quick_sort(List<Double> list, int low, int high){
        // list.get(high);
        // if (list.size()==0) return;
        // if (low >= high) return;
        double pivot= list.get( (int)high/2+low/2) ;
        int i = low, j = high;
        while (i <= j)
        {
            // find the element bigger than the pivot from the beginning
            while (list.get(i) < pivot)
            {
                i++;
            }
            // find the element smalled than the pivot from the end
            while (list.get(j) > pivot)
            {
                j--;
            }
            // if the index i and j crossed
            if (i <= j)
            {
                swap_ele(list,i,j);
                i++;
                j--;
            }
        }
        // do the quick sort for left and right parts
        if (low < j){
            quick_sort(list, low, j);
        }
        if (high > i){
            quick_sort(list, i, high);
        }

    }
    public void swap_ele(List<Double> list,int i, int j) {
        double temp=list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
}