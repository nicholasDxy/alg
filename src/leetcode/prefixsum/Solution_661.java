package leetcode.prefixsum;

/**
 * 661. 图片平滑器
 */
public class Solution_661 {

    public static void main(String[] args) {
        int[][] prefix = new int[][]{{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};

        new Solution_661().imageSmoother(prefix);
    }

    public int[][] imageSmoother(int[][] img) {
        if (img == null || img.length == 0 || img[0].length == 0) {
            return null;
        }
        int[][] prefix = new int[img.length + 4][img[0].length + 4]; // 最外包两层
        for (int i = 2; i < prefix.length - 2; i++) {
            int total = 0;
            for (int j = 2; j < prefix[0].length - 2; j++) {
                total += img[i - 2][j - 2];
                prefix[i][j] = total + prefix[i - 1][j];
            }
        }
        print2dimenArray(prefix);
        int[][] result = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                int startX = i - 1, startY = j - 1, endX = i + 1, endY = j + 1; // 这里是找到原矩阵中九宫格最左上与最右下坐标
                startX = startX >= 0 ? startX : 0;
                startY = startY >= 0 ? startY : 0;
                endX = endX < img.length ? endX : img.length - 1;
                endY = endY < img[0].length ? endY : img[0].length - 1;
                int nums = (endX - startX + 1) * (endY - startY + 1); // 计算九宫格中数字数量
                startX--;
                startY--; // 起始点左上格
                startX += 2;
                startY += 2;
                endX += 2;
                endY += 2; // 这里是进行前缀和九宫格偏移
                int total = prefix[endX][endY] - prefix[startX][endY] - prefix[endX][startY] + prefix[startX][startY];// 这里是通过前缀和矩阵计算九宫格总和
                result[i][j] = (int) Math.floor((float) total / nums);
            }
        }
        print2dimenArray(result);
        return result;
    }

    private void print2dimenArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + ",");
            }
            System.out.println();
        }
    }


}
