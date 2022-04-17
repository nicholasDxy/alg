package leetcode;

/**
 * 10. 正则表达式匹配
 */
public class Solution_10 {

    public static void main(String[] args) {
        System.out.println(new Solution_10().isMatch("ba",
                ".*a*a"));
    }

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1]; // dp[i][j]表示p的前i-1个是否可以匹配s的前j-1
        //特殊
        if (".*".equals(p)) {
            return true;
        }
        // 初始化
        dp[0][0] = true;
        int i = 2;
        while (i < p.length() + 1) {
            if (p.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 2][0];
            }
            i +=2;
        }
        // 匹配
        for (int pIndex = 1; pIndex < p.length() + 1; pIndex++) {
            for (int sIndex = 1; sIndex < s.length() + 1; sIndex++) {
                if (p.charAt(pIndex - 1) == s.charAt(sIndex - 1) || p.charAt(pIndex - 1) == '.') {
                    dp[pIndex][sIndex] = dp[pIndex - 1][sIndex - 1];
                } else if (p.charAt(pIndex - 1) == '*') {
                    // *不匹配
                    dp[pIndex][sIndex] = dp[pIndex - 2][sIndex];
                    if (p.charAt(pIndex - 2) == s.charAt(sIndex - 1) || p.charAt(pIndex - 2) == '.') {
                        // *前一个字符匹配成功，则看前一个s字符dp是否匹配成功
                        dp[pIndex][sIndex] |= dp[pIndex][sIndex - 1]; //注意这里是｜=，选择或者不选择匹配当前*字符，只要符合匹配规则就true
                    }
                }
            }
        }
        for (int pIndex = 0; pIndex < p.length() + 1; pIndex++) {
            for (int sIndex = 0; sIndex < s.length() + 1; sIndex++) {
                System.out.print(dp[pIndex][sIndex] + "  ");
            }
            System.out.println();
        }
        return dp[p.length()][s.length()];
    }
//
//    public boolean isMatch(String s, String p) {
//        boolean[][] dp = new boolean[p.length()][s.length()]; // dp[i][j]表示p的前i-1个是否可以匹配s的前j-1
//        //特殊
//        if (".*".equals(p)) {
//            return true;
//        }
//        // 初始化
//        if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
//            dp[0][0] = true;
//        } else {
//            return false;
//        }
//        // 开始匹配
//        for (int pIndex = 1; pIndex < p.length(); pIndex++) {
//            for (int sIndex = 0; sIndex < s.length(); sIndex++) {
//                if (dp[pIndex][sIndex]) {
//                    //本位置已经通过规则
//                    continue;
//                }
//                char pChar = p.charAt(pIndex);
//                if (pChar == '.') {
//                    if (sIndex>0) {
//                        dp[pIndex][sIndex] = dp[pIndex - 1][sIndex - 1];
//                    } else {
//                        dp[pIndex][sIndex] = true;
//                    }
//                } else if (pChar == '*') {
//                    if (!dp[pIndex - 1][sIndex]) {
//                        //*之前的就匹配失败了，那么无需再去匹配了
//                        continue;
//                    }
//                    char lastPChar = p.charAt(pIndex - 1);
//                    if (lastPChar == '.') {
//                        // .*可以匹配之后所有字符,可直接填满
//                        while (sIndex < s.length()) {
//                            dp[pIndex][sIndex] = true;
//                            sIndex++;
//                        }
//                    } else {
//                        // 只匹配相同字符
//                        while (sIndex < s.length()) {
//                            if (s.charAt(sIndex) != lastPChar) {
//                                break;
//                            }
//                            dp[pIndex][sIndex] = true;
//                            sIndex++;
//                        }
//                    }
//                    break;
//                } else {
//                    if (sIndex<=0 || !dp[pIndex - 1][sIndex - 1]) {
//                        // 上一位匹配失败
//                        continue;
//                    }
//                    if (s.charAt(sIndex) == p.charAt(pIndex)) {
//                        dp[pIndex][sIndex] = true;
//                    }
//                }
//            }
//        }
//        for (int pIndex = 0; pIndex < p.length(); pIndex++) {
//            for (int sIndex = 0; sIndex < s.length(); sIndex++) {
//                System.out.print(dp[pIndex][sIndex] + "  ");
//            }
//            System.out.println();
//        }
//
//        return dp[p.length() - 1][s.length() - 1];
//    }

}
