import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-arraylist/problem?isFullScreen=true
public class ArrayListSearchSolution {

    static boolean DEBUG = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // read n, the number of lines of input
        int n = scanner.nextInt();
        if(DEBUG) System.out.printf("Read %d lines\n", n);
        // read n lines with zero or more integers
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for(int line = 0; line < n; line++) {
           ArrayList<Integer> currentLineList = new ArrayList<Integer>();
           list.add(currentLineList);
           // read d - the number of integers for the current line
           int d = scanner.nextInt();
           if(DEBUG) System.out.printf("line %d, Read %d integers\n", line, d);
           // add integers on current line to list for current line
           for(int i = 0; i < d; i++) {
              int nextInt = scanner.nextInt();
              if(DEBUG) System.out.printf("%d ", nextInt);
              currentLineList.add(nextInt);
           }
           if(DEBUG) System.out.println("");
        }
        // read q - the number of queries
        int q = scanner.nextInt();
        if(DEBUG) System.out.printf("%d queries\n", q);
        for(int j = 0; j < q; j++) {
           int x = scanner.nextInt();
           int y = scanner.nextInt();
           if(DEBUG) System.out.printf("query: x: %d y: %d\n", x, y);
           try {
            // adjust for zero based index, 1 based queries
            int value = list.get(x - 1).get(y - 1);
            if(DEBUG) System.out.printf("value at: x: %d y: %d = %d\n", x, y, value);
            System.out.println(value);
           } catch(Exception e) {
            if(DEBUG) System.out.println(e);
            System.out.println("ERROR!");
           }
        }
    }
}