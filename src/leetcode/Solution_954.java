package leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 954. 二倍数对数组
 */
public class Solution_954 {


    public static void main(String[] args) {
        System.out.println(new Solution_954().canReorderDoubled(new int[]{2,1,2,1,1,1,2,2}));
    }

    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        List<Integer> hashSet = new ArrayList<>();
        for (int i : arr) {
            if (i<0) {
                if (hashSet.contains(i * 2)) {
                    hashSet.remove(i * 2);
                } else {
                    hashSet.add(i);
                }
            } else {
                if (i % 2 == 0 && hashSet.contains(i / 2)) {
                    hashSet.remove(i / 2);
                } else {
                    hashSet.add(i);
                }
            }
        }
        return hashSet.isEmpty();
    }
}
