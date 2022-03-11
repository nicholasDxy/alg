package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.permute(new int[]{1,2,3}));
    }

    public static void print(Object object) {
        System.out.println(object.toString());
    }

    public static void printAddress(Object object) {
        System.out.println(System.identityHashCode(object));
    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        backtrack(nums, list);
        return res;

    }

    public void backtrack(int[] nums, LinkedList<Integer> list) {

        if (list.size() == nums.length) {
            // LinkedList<Integer> linkedList = new LinkedList(list);
            printAddress(list);
            res.add(list); // 注意要初始化，不能直接用lists
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i]))
                continue;

            list.add(nums[i]);
            backtrack(nums, list);
            list.remove(list.size()-1);
        }
    }
}
