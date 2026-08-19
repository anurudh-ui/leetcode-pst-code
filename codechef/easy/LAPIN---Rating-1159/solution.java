import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String s = sc.next();
                int len = s.length();
                
                int[] leftCount = new int[26];
                int[] rightCount = new int[26];
                
                for (int i = 0; i < len / 2; i++) {
                    leftCount[s.charAt(i) - 'a']++;
                }
                
                for (int i = (len + 1) / 2; i < len; i++) {
                    rightCount[s.charAt(i) - 'a']++;
                }
                
                boolean isLapin = true;
                for (int i = 0; i < 26; i++) {
                    if (leftCount[i] != rightCount[i]) {
                        isLapin = false;
                        break;
                    }
                }
                
                if (isLapin) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        sc.close();
    }
}