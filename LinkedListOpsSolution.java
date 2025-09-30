import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-list/problem?isFullScreen=true
public class LinkedListOpsSolution {

    static boolean DEBUG = false;
    public static void main(String[] args) {
        // read n, the number of elements in L
        // read n space seperated members of L
        // read q, the number of queries
        //   each query is 2Q subsequent lines:
        //     first line is operation
        //       if operation == Insert
        //          next line is x y
        //          insert y into L at index x
        //       else if operation == Delete
        //          next line is x
        //          delete x'th element from L
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new LinkedList<Integer>();
        if(DEBUG) { System.out.printf("%d element list: ", n); }
        for(int i = 0; i < n; i++) {
            int nextInt = scanner.nextInt();
            list.add(nextInt);
            if(DEBUG) { System.out.printf("%d ", nextInt); }
        }
        int q = scanner.nextInt();
        if(DEBUG) { System.out.printf("\n q = %d\n", q); }
        for(int i = 0; i < q; i++) {
            // nextInt leaves trailing newline
            scanner.nextLine();
            String op = scanner.nextLine();
            if(DEBUG) { System.out.printf("Read operation %s\n", op); }
            if(op.equals("Insert")) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if(DEBUG) { System.out.printf("Insert y: %d at x: %d (current len %d) \n", y, x, list.size()); }
                list.add(x, y);
            } else if(op.equals("Delete")) {
                int x = scanner.nextInt();
                if(DEBUG) { System.out.printf("Delete x: %d\n", x); }
                list.remove(x);
            }
        }
        scanner.close();
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()) {
            System.out.printf("%d ", iter.next());
        }
    }
}