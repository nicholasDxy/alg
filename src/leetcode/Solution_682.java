package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 682. 棒球比赛
 */
public class Solution_682 {

    public static void main(String[] args) {
        new Solution_682().calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"});
    }

    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }
        int total = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int addNum = 0; // 每次加上的数
        for (String op : ops) {
            if ("C".equals(op)) {
                addNum = -stack.pop();
            } else if ("D".equals(op)) {
                addNum = 2 * stack.getFirst();
                stack.push(addNum);
            } else if ("+".equals(op)) {
                int curLast = stack.pop();
                int secondLastNum = stack.getFirst();
                addNum = curLast + secondLastNum;
                stack.push(curLast);
                stack.push(addNum);
            } else {
                addNum = Integer.parseInt(op);
                stack.push(addNum);
            }
            total += addNum;
            System.out.print("total:" + total+" stack: ");
            printStack(stack);
        }
        return total;
    }

    private void printStack(Deque stack) {
        for(Object o:stack) {
            System.out.print(o+",");
        }
        System.out.println();
    }
}
