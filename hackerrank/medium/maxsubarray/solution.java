import java.io.*;
import java.util.*;

public class Solution {

    public static List<Long> maxSubarray(List<Integer> arr) {
        long maxSubarray = arr.get(0);
        long current = arr.get(0);

        // Maximum subarray - Kadane's algorithm
        for (int i = 1; i < arr.size(); i++) {
            current = Math.max(arr.get(i), current + arr.get(i));
            maxSubarray = Math.max(maxSubarray, current);
        }

        // Maximum subsequence
        long maxSubsequence = 0;
        int largest = arr.get(0);

        for (int x : arr) {
            if (x > 0) {
                maxSubsequence += x;
            }

            largest = Math.max(largest, x);
        }

        // If all numbers are negative, choose the largest one
        if (maxSubsequence == 0) {
            maxSubsequence = largest;
        }

        List<Long> result = new ArrayList<>();
        result.add(maxSubarray);
        result.add(maxSubsequence);

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }

            List<Long> result = maxSubarray(arr);

            System.out.println(result.get(0) + " " + result.get(1));
        }

        sc.close();
    }
}
