package leetcode.primenum;

import java.util.Arrays;

/**
 * 204. 计数质数
 */
public class Solution_204 {
    public int countPrimes(int n) {
        boolean[] primeList = new boolean[n + 1];
        Arrays.fill(primeList, true);
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (primeList[i]) {
                result++;
                if ((long)i*(long)i < n) {
                    int j = i * i;
                    while (j <= n) {
                        primeList[j] = false;
                        j += i;
                    }
                }
            }
        }
        return result;
    }
}
