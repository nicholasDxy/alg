package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_22 {

    public static void main(String[] args) {
        System.out.println(new Solution_22().generateParenthesis(3));
    }

    private static final char LEFT = '(';

    private static final char RIGHT = ')';

    public List<String> generateParenthesis(int n) {
        backTrack(new StringBuilder(), n, n);
        return combinationList;
    }

    ArrayList<String> combinationList = new ArrayList<>();

    private void backTrack(StringBuilder sb, int remainLeftBrackets, int remainRightBrackets) {
        if (remainLeftBrackets == 0 && remainRightBrackets == 0) {
            // 左右用光，加入
            combinationList.add(sb.toString());
            return;
        } else if (remainRightBrackets == 0) {
            // 只剩左括号，非法,返回上层
            return;
        }
        if (remainLeftBrackets > 0) {
            sb.append(LEFT);
            backTrack(sb, remainLeftBrackets - 1, remainRightBrackets);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (remainRightBrackets > 0 && remainRightBrackets > remainLeftBrackets) {
            // 剩余右括号数量小于剩余左括号数量才可以用，否则非法
            sb.append(RIGHT);
            backTrack(sb, remainLeftBrackets, remainRightBrackets - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
