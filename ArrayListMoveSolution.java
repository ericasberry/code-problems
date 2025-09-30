import java.util.*;

//https://www.hackerrank.com/challenges/java-1d-array/problem?isFullScreen=true
public class Solution {
    static boolean DEBUG = false;

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        // test for all possible starting values of i, return true as soon as
        // winning scenario is identified; return false after all possibilities exhausted
        // for given position i:
        // (1) game[i+1] == 0, can move to i + 1
        // (2) if game[i+leap] == 0, can move to i + leap
        // (3) if game[i-1] == 0, can move to i - 1
        // (4) if i == n -1, or i + leap >= n, win
        final int n = game.length;
        // iterate through each starting position
        if(DEBUG) {
            for(int i = 0; i < game.length; i++) {
                System.out.printf("%d ", game[i]);
            }
            System.out.println();
        }
        boolean seen[] = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);
        while(!stack.isEmpty()) {
            int i = stack.pop();
            if(i < 0 || i >= n || seen[i]) continue;
            seen[i] = true;

            if(DEBUG) System.out.printf("Testing scenarios i: %d, n: %d\n", i, n);
            if(i == n - 1) {
                if(DEBUG) System.out.printf("i: %d == n-1: %d: WIN!\n", i, n - 1);
                return true;
            }
            if(i + leap >= n) {
                if(DEBUG) System.out.printf("i + leap: %d => n: %d: WIN!\n", i + leap, n);
                return true;
            }

            if(i+1 < n && game[i + 1] == 0 && !seen[i+1]) {
                if(DEBUG) System.out.printf("game[i-1] == 0, add attempt moving i from %d to %d\n", i, i+1);
                stack.push(i+1);
            }
            if(i -1 > 0 && game[i - 1] == 0 && !seen[i-1]) {
                if(DEBUG) System.out.printf("game[i-1] == 0, add attempt moving i from %d to %d\n", i, i-1);
                stack.push(i - 1);
            }

            if(i + leap < n && game[i + leap] == 0) {
                if(DEBUG) System.out.printf("game[i+leap] == 0, moving i from %d to %d\n", i, i + leap);
                stack.push(i + leap);
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }}