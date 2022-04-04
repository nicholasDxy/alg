package leetcode;

public class Solution_744 {


    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] <= target) {
            return letters[0];
        }
        return binarySearch(letters, target, 0, letters.length - 1);
    }

    private char binarySearch(char[] letters, char target, int start, int end) {
        if (start >= end) {
            return letters[end];
        }
        int middle = (end + start) / 2;
        if (letters[middle] <= target) {
            return binarySearch(letters, target, middle + 1, end);
        } else {
            return binarySearch(letters, target, start, middle);
        }
    }


    private char violent(char[] letters, char target) {
        if (target >= letters[letters.length - 1]) {
            return letters[0];
        } else {
            for (char c : letters) {
                if (c > target) {
                    return c;
                }
            }
        }
        return '0';
    }
}
