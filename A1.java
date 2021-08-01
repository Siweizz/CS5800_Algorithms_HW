package ca.neu;

import java.util.*;

/**
 * Finding the closest number pair
 * 1. Generate n, non-negative and non-duplicate elements
 * 2. Sort a list using the assigned sorting algorithm
 * 3. Find the closest number pair and display the difference
 */
public class ClosestNumberPairChallenge {

    private static int n = 25;
    private static int range = 1000000;

    private static List<Integer> elements = new ArrayList<>();

    /**
     * Generate random elements
     *
     * @param n     - number of elements
     * @param range - range
     * @return ArrayList
     */
    private static List<Integer> generateRandomElements(int n, int range) {
        Set r = new LinkedHashSet(n);
        Random random = new Random();
        while (r.size()<n) {
            int i=random.nextInt(range);
            r.add(i);
        }
        return new ArrayList<>(r);
    }

    /**
     * Sort the @param list
     *
     * @param list - a list to be sorted
     */
    private static void sortArray(List<Integer> list) {
        //Iterator it1=list.iterator();
        int list_max=0;
        for (int i = 0;i<list.size();i++){
            if (list.get(i)>list_max) {
                list_max=list.get(i);
            }
        }
        for (int exp =1; list_max/exp>0; exp*=10)
        {
            int output[]=new int[n];
            int i;
            int count[]= new int[10];
            Arrays.fill(count,0);
            for (i=0;i<n;i++)
                count[list.get(i)/exp%10]++;

            for (i = 1; i < 10; i++)
                count[i] += count[i - 1];


            for (i = n - 1; i >= 0; i--)
            {
                output[count[ (list.get(i)/exp)%10 ] - 1] = list.get(i);
                count[ (list.get(i)/exp)%10 ]--;
            }
            //System.out.println(output[2]);

            for (i = 0; i < n; i++)
                list.set(i,output[i]) ;
        }

    }

    /**
     * Find the closest number pair
     *
     * @param sortedList - sorted list, used for calculation
     * @return String containing the pair and the difference; Example "The closest pair: 412708 412808, the difference = 100"
     */
    private static String findClosestNumberPair(List<Integer> sortedList) {
        int max_pair_index=0;
        int minimum_diff=1000000;
        for (int i=0;i<sortedList.size()-1;i++) {
            if (sortedList.get(i+1)-sortedList.get(i)<minimum_diff) {
                max_pair_index=i;
                minimum_diff=sortedList.get(i+1)-sortedList.get(i);
            }
        }
        String output;
        output = "The closest pair:"+Integer.toString(sortedList.get(max_pair_index))+ " ";
        output += Integer.toString(sortedList.get(max_pair_index+1))+ ", the difference = ";
        output += Integer.toString(minimum_diff);
        return output;
    }

    public static void main(String[] args) {
        elements = generateRandomElements(n, range);
        System.out.println(elements);
        sortArray(elements);
        System.out.println(elements);
        System.out.println(findClosestNumberPair(elements));
    }
}
