package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        // 只需要加这三行代码
        if (list1.length > list2.length) {
            return findRestaurant(list2, list1);
        }
        Map<String, Integer> list1Map = new HashMap<>();
        for (int index = 0; index < list1.length; index++) {
            list1Map.put(list1[index], index);
        }
        List<String> result = new ArrayList<>();
        int minIndex = Integer.MAX_VALUE;
        for (int index = 0; index < list2.length; index++) {
            String curStr = list2[index];
            if (list1Map.containsKey(curStr)) {
                int curIndex = list1Map.get(curStr) + index;
                if (curIndex < minIndex) {
                    minIndex = curIndex;
                    result.clear();
                    result.add(curStr);
                } else if (curIndex == minIndex) {
                    result.add(curStr);
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
