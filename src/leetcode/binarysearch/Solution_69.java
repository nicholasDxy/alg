package leetcode.binarysearch;

public class Solution_69 {

    public static void main(String[] args) {
        Solution_69 solution69 = new Solution_69();
        solution69.mySqrt(4);
    }
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int pos = 0,mid = 0, left =0,right = x;
        while(left<=right) {
            mid = left + (right - left)/2;
            if (mid!=0 && mid >= x/mid) {
                pos = mid;
                right= mid -1;
            }else {
                left = mid + 1;
            }
        }
        return pos;
    }
}
