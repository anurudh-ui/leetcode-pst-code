# Matrix Layer Rotation

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a 2D  matrix of dimension $m \times n$ and a positive integer $r$. You have to rotate the matrix $r$ times and print the resultant matrix. Rotation should be in anti-clockwise direction.  

Rotation of a $4x5$ matrix is represented by the following figure. Note that in one rotation, you have to shift elements by one step only.

![matrix-rotation](https://hr-challenge-images.s3.amazonaws.com/2517/matrix-rotation.png)

It is guaranteed that the minimum of _m_ and _n_ will be even.  

As an example rotate the Start matrix by 2:

<pre>
	Start		  First 		  Second
	 1 2 3 4	   2  3  4  5      3  4  5  6
	12 1 2 5  ->   1  2  3  6 ->   2  3  4  7
	11 4 3 6      12  1  4  7      1  2  1  8
	10 9 8 7      11 10  9  8     12 11 10  9
</pre>

**Function Description**  

Complete the *matrixRotation* function in the editor below.  

matrixRotation has the following parameter(s):  

- *int matrix[m][n]:* a 2D array of integers  
- *int r:* the rotation factor   

**Prints**   
It should print the resultant 2D integer array and return nothing.  Print each row on a separate line as space-separated integers.  

**Input Format**

The first line contains three space separated integers, $m$, $n$, and $r$, the number of rows and columns in $matrix$, and the required rotation.    
The next $m$ lines contain $n$ space-separated integers representing the elements of a row of $matrix$.  

**Constraints**

$2 \le \text{m, n} \le 300$  
$1 \le r \le 10^9$  
$min(m, n) \% 2 = 0$  
$1 \le matrix[i][j] \le 10^8 \text{ where }i \in [1 \dots m] \text{ and }j \in [1 \dots n]$
 

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-08-19T04:10:22.517Z  

```java
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

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/matrix-rotation-algo/problem)