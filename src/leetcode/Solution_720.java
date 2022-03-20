package leetcode;

import java.util.*;

/**
 * 720. 词典中最长的单词
 */
public class Solution_720 {

    public static void main(String[] args) {
        new Solution_720().longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"});
    }


    public String longestWord(String[] words) {
        CharNode firstPos = new CharNode();
        for (String word : words) {
            firstPos.insert(word);
        }
        backTrack(firstPos, new StringBuilder());
        return mLongestWord;
    }

    /**
     * 回溯法， 找到每个字符都是end的最长string
     */
    private String mLongestWord = "";

    public void backTrack(CharNode curPos, StringBuilder sb) {
        for (int i = 25; i >= 0; i--) {
            //从后向前遍历，找到字典序最小的
            if (curPos.nodes[i] == null || !curPos.nodes[i].end) {
                continue;
            }
            //找到不为空且为结尾的,加入
            sb.append((char)(i + 'a'));
            if (mLongestWord.length() <= sb.length()) {
                mLongestWord = sb.toString();
            }
            backTrack(curPos.nodes[i], sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    static class CharNode {
        public CharNode() {

        }

        public void insert(String word) {
            CharNode curNode = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (curNode.nodes[index] == null) {
                    curNode.nodes[index] = new CharNode();
                }
                curNode = curNode.nodes[index];
                if (i == word.length() - 1) {
                    curNode.end = true;
                }
            }
        }

        public CharNode[] nodes = new CharNode[26];
        public boolean end = false;
    }

    /***********************8
     * hashMap
     */
    public String hashMap(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length(); // 长的在后
                }
                return o2.compareTo(o1); // 字典序小的在后
            }
        });
        Set<String> set = new HashSet<>(); // 符合条件的集合
        set.add("");
        String ans = "";
        for (String s : words) {
            String subS = s.substring(0, s.length() - 1);
            if (set.contains(subS)) {
                ans = s;
                set.add(s);
            }
        }
        return ans;
    }

    /*********************************************************************
     * 暴力解
     */
    private String violent(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        String curStr = null;
        String subStr = null;
        int maxLength = 0;
        String maxString = "";
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], 0);
        }
        for (int i = 0; i < words.length; i++) {
            curStr = words[i];
            boolean isValid = true;
            for (int index = 1; index < curStr.length(); index++) {
                if (!map.containsKey(curStr.substring(0, index))) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                if (curStr.length() > maxLength) {
                    maxLength = curStr.length();
                    maxString = curStr;
                } else if (curStr.length() == maxLength) {
                    maxString = compareStrByDic(curStr, maxString);
                }
            }
        }
        return maxString;
    }

    private String compareStrByDic(String str1, String str2) {
        int index = 0;
        while (index < str1.length() && index < str2.length()) {
            if (str1.charAt(index) < str2.charAt(index)) {
                return str1;
            } else if (str1.charAt(index) > str2.charAt(index)) {
                return str2;
            }
            index++;
        }
        if (index < str1.length()) {
            return str2;
        }
        return str1;
    }
}
