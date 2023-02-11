package leetcode.sort;

public class SortAlg {

    /**
     * 快排
     *
     * @param nums
     * @param start
     * @param end
     */
    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = nums[start];
        int left = start;
        int right = end;
        while (right > left) {
            while (right > left && nums[right] > pivot) {
                right--;
            }
            if (right > left) {
                nums[left] = nums[right];
                left++;
            }
            while (right > left && nums[left] < pivot) {
                left++;
            }
            if (right > left) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = pivot;
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }

    private static void switchIndex(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 4, 3, 6, 1, 0};
//        SortAlg.bubbleSort(arr, 0, 6);
        for (int i : arr) {
            System.out.println(i);
        }


    }


}
