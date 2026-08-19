import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

   
    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> list = new ArrayList<>();

            // 1. Extract elements of the current layer in clockwise order
            // Top row
            for (int j = layer; j < n - layer; j++) {
                list.add(matrix.get(layer).get(j));
            }
            // Right column
            for (int i = layer + 1; i < m - layer; i++) {
                list.add(matrix.get(i).get(n - 1 - layer));
            }
            // Bottom row
            for (int j = n - 2 - layer; j >= layer; j--) {
                list.add(matrix.get(m - 1 - layer).get(j));
            }
            // Left column
            for (int i = m - 2 - layer; i > layer; i--) {
                list.add(matrix.get(i).get(layer));
            }

            // 2. Rotate the extracted list anti-clockwise (shift left)
            int effectiveRotations = r % list.size();
            Collections.rotate(list, -effectiveRotations);

            // 3. Put the rotated elements back into the matrix
            int idx = 0;
            // Top row
            for (int j = layer; j < n - layer; j++) {
                matrix.get(layer).set(j, list.get(idx++));
            }
            // Right column
            for (int i = layer + 1; i < m - layer; i++) {
                matrix.get(i).set(n - 1 - layer, list.get(idx++));
            }
            // Bottom row
            for (int j = n - 2 - layer; j >= layer; j--) {
                matrix.get(m - 1 - layer).set(j, list.get(idx++));
            }
            // Left column
            for (int i = m - 2 - layer; i > layer; i--) {
                matrix.get(i).set(layer, list.get(idx++));
            }
        }

        // 4. Print the final rotated matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix.get(i).get(j) + (j == n - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
