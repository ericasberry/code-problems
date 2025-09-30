import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// my code
class Hourglass {
    private int originRow;
    private int originColumn;
    private List<List<Integer>> arr;

    public Hourglass(List<List<Integer>> arr, int row, int column) {
        this.originRow = row;
        this.originColumn = column;
        this.arr = arr;
    }

    public int getSum() {
        int sum = arr.get(originRow).get(originColumn) +
                arr.get(originRow).get(originColumn + 1) +
                arr.get(originRow).get(originColumn + 2) +
                arr.get(originRow + 1).get(originColumn + 1) +
                arr.get(originRow + 2).get(originColumn) +
                arr.get(originRow + 2).get(originColumn + 1) +
                arr.get(originRow + 2).get(originColumn + 2);
        return sum;
    }

    public String toString() {
        StringBuilder ts = new StringBuilder();
        ts.append(String.format("%2d %2d %2d\n",
                arr.get(originRow).get(originColumn),
                arr.get(originRow).get(originColumn + 1),
                arr.get(originRow).get(originColumn + 2)
        ));
        ts.append(String.format("  %2d\n",
                arr.get(originRow + 1).get(originColumn + 1)
        ));
        ts.append(String.format("%2d %2d %2d\n",
                arr.get(originRow + 2).get(originColumn),
                arr.get(originRow + 2).get(originColumn + 1),
                arr.get(originRow + 2).get(originColumn + 2)
        ));
        ts.append(String.format("Sum = %d\n", this.getSum()));
        return ts.toString();
    }
}

public class HourglassSolution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // list of lists of integers
        List<List<Integer>> arr = new ArrayList<>();

        for (int row = 0; row < 6; row++) {
            // split string into space delimited
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            // allocate a new list of integers for current row
            List<Integer> arrRowItems = new ArrayList<>();

            for (int column = 0; column < 6; column++) {
                // get the next column of digits
                int arrItem = Integer.parseInt(arrRowTempItems[column]);
                // add to list for current row
                arrRowItems.add(arrItem);
            }
            // add current row to list
            arr.add(arrRowItems);
        }

        bufferedReader.close();

        int maxSum = Integer.MIN_VALUE;

        // my code
        for(int row = 0; row < 4; row++) {
            for(int column = 0; column < 4; column ++) {
                Hourglass hourGlass = new Hourglass(arr, row, column);
                //System.out.println(hourGlass);
                if(hourGlass.getSum() > maxSum) {
                    maxSum = hourGlass.getSum();
                }
            }
        }

        System.out.println(maxSum);

    }
}
