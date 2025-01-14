import java.util.*;

public class Solution {
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        Map<Integer, Integer> mpp1 = new HashMap<>();
        Map<Integer, Integer> mpp2 = new HashMap<>();
        for (int i : A) {
            mpp1.put(i, 0);
            mpp2.put(i, 0);
        }
        // map ready ho gaya
        int ans[] = new int[A.length];
        int count = 0;
        int k = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i]) {
                count++;
            } else {
                if (mpp1.get(A[i]) < mpp2.get(A[i]))
                    count++;
                if (mpp2.get(B[i]) < mpp1.get(B[i]))
                    count++;
            }
            ans[k++] = count;
            mpp1.put(A[i], mpp1.get(A[i]) + 1);
            mpp2.put(B[i], mpp2.get(B[i]) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Length of the array : ");
        int n = sc.nextInt();
        System.out.println("Enter the elements of Array1 : ");
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter the permutation of Array1 i.e. going to be the Array2 : ");
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        System.out.println("Prefix common elements are : " + Arrays.toString(findThePrefixCommonArray(arr1, arr2)));
    }
}