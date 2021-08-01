package ca.neu;

import java.util.Random;

public class DecodeAndCount {

    private static Random random = new Random();
    private static int number;
    private static String binaryRepresentation;
    private static Integer[] array;

    public static void main(String[] args) {
        number = generateRandomNumber();
        binaryRepresentation = convertNumberIntoBinaryString(number);
        System.out.println(binaryRepresentation);
        array = convertStringToArray(binaryRepresentation);
        System.out.println("The number of 1's is equal to: " + countNumberOf1s(array, 0, array.length - 1));
    }

    private static int countNumberOf1s(Integer[] array, int low, int high) {
        //TODO: Remember to sort array
        int n = array.length;
        int sum=0;
        for(int i = 0; i < n; i++)
        {
            if(array[i] == 1)
                sum++;
        }
        return sum;
    }


    private static Integer[] convertStringToArray(String binaryRepresentation) {
        //TODO: Convert String into Integer[]
        System.out.println(binaryRepresentation);
        Integer[] out=new Integer[binaryRepresentation.length()];
        for (int i=0;i<binaryRepresentation.length();i++) {
            out[i] =  binaryRepresentation.charAt(i) - '0';
            //System.out.println(out[i]);
        }
        return out;
    }


    private static int generateRandomNumber() {
        return random.nextInt(1000);
    }

    private static String convertNumberIntoBinaryString(int n) {
        //TODO: Convert Number to binary form (1's and 0's)
        String binary_string=Integer.toBinaryString(n);
        return binary_string;
    }
}
