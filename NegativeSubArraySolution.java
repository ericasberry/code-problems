import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NegativeSubArraySolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int entry = 0;
        while(entry < n) {
            arr[entry++] = scanner.nextInt();
        }
        scanner.close();
        int negativeSubbarrayCount = 0;
        // e.g. 1 2 3 4
        // start with 1st element
        for(int i = 0; i < n; i++) {
            // scan each sub-array: [1], [1,2], [1,2,3], [1,2,3,4], [2], [2,3] ...
            // compute each sum
            int sum = 0;

            for(int j = i; j < n; j++) {
                sum += arr[j];
                if(sum < 0) {
                    negativeSubbarrayCount++;
                }
            }
        }
        System.out.println(negativeSubbarrayCount);
    }
}