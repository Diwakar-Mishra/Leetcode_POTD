package Jan13_2025;
import java.util.*;

public class Jan13_2025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution obj = new Solution();
        String s = sc.next();
        System.out.println("minimum length of the string obtained : " + obj.minimumLength(s));
    }

}

class Solution {
    public int minimumLength(String s) {
        int[] hash = new int[26];
        for (char ch : s.toCharArray()) {
            hash[ch - 'a']++;
        }
        int length = 0;
        for (int i : hash) {
            if (i == 0)
                continue;
            if (i % 2 == 1)
                length = length + 1;
            else
                length = length + 2;
        }
        return length;
    }
}