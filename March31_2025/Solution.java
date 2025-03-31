import java.util.*;

class Solution {
    public long putMarbles(int[] weights, int k) {
        // a b c d => ek array hai then, humko agar isko 2 parts mai divide karna hai
        // then, it can be ...
        // (a+a)+(b+d) or (a+b)+(c+d) or (a+c)+(d+d)
        // ek baat notice ki aapne ki kaise bhi cut maaro first and last element toh
        // hamesha hi aapke answer mai aayenge hi chaahe minimum score ko calculate
        // karne jaao ya fir maximum score ko calculate karne jaao
        // toh unko abhi k liye htaa dete hai
        // toh hamaare paas kya case banaa ?
        // (a+b) or (b+c) or (c+d) mai se koi bhi ek pair ko uthaa lo
        // basically, ye all possible consecutive pairs hai of [a,b,c,d]
        // kyunki k = 2 hai toh humein koi bhi ek pair uthaa lenaa hai
        // agar maximum score chaahiye toh wo pair uthaayenge jiski value maximum hogii
        // toh kya aapne notice kiyaa ki if k == 3 hotaa toh 2 pairs uthaane hote and so
        // on ...
        int n = weights.length;
        if (k == 0)
            return 0; // koi cut hi nahi lagaana
        int[] pairs = new int[n - 1];
        for (int i = 0; i <= n - 2; i++) {
            pairs[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(pairs);
        System.out.println(Arrays.toString(pairs));
        long maxi = 0;
        long mini = 0;
        for (int i = 0; i < k - 1; i++) {
            // picking the k-1 pairs from the front to get the minimum score
            mini += pairs[i];
        }
        // n-2 mai pehla, n-3 mai doosra, n-4 mai teesra (n-1 - (kaunsa waala)) index
        for (int i = n - 2; i >= (n - 1) - (k - 1); i--) {
            maxi += pairs[i];
        }
        System.out.println(maxi + "   " + mini);
        return maxi - mini;
    }
}