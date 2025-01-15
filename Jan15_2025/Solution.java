import java.util.*;

class Solution {
    public static int minimizeXor(int num1, int num2) {
        int n = Integer.bitCount(num2); // number of set bits in the nums1
        ArrayList<Integer> setBitPos = new ArrayList<Integer>();
        int pos = 0;
        int temp1 = num1;
        while (temp1 != 0) {
            if ((temp1 & 1) == 1)
                setBitPos.add(pos);
            pos++;
            temp1 = temp1 >> 1;
        }
        // System.out.println(setBitPos);
        if (setBitPos.size() == n) {
            // number of set bits in num2 = number of set bits in num1
            return num1;
        } else if (setBitPos.size() > n) {
            int temp = 0;
            int i = setBitPos.size() - 1;
            while (n > 0) {
                temp += (int) Math.pow(2, setBitPos.get(i));
                i--;
                n--;
            }
            return temp;
        } else {
            // numberof bits set in num1 < number of setbits in num2
            // toh jo bits num1 mai set hai unko set rehne dete hai and
            // jitni bits kam padd rahi hai uunhe extreme most left se set kar dete hai
            int temp = num1;
            int count = n - setBitPos.size();
            int pos1 = 0;
            while (count > 0) {
                if ((temp & (1 << pos1)) == 0) {
                    // set that bit and do count --
                    count--;
                    temp = temp | (1 << pos1);
                }
                pos1++;
            }
            return temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(minimizeXor(3, 5));
    }
}