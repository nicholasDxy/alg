package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 20. 有效的括号
 */
public class Solution_20 {

    public static void main(String[] args) {
        System.out.println(new Solution_20().isValid("{[]}"));
    }

    private static final Map<Character, Character> CHAR_MAP = new HashMap() {
        {
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }
    };


    public boolean isValid(String s) {
        ArrayDeque<Character> charStack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (charStack.isEmpty()) {
                charStack.addFirst(curChar);
                continue;
            }
            char topChar = charStack.getFirst();
            if (CHAR_MAP.containsKey(topChar) && CHAR_MAP.get(topChar) == curChar) {
                // 一对,弹出栈顶元素
                charStack.pollFirst();
            } else {
                // 不是一对， 入栈
                charStack.addFirst(curChar);
            }
        }
        return charStack.isEmpty();
    }
}
