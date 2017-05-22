package algorithm;

/**
 * Created by fanjiangqi on 2017/5/22.
 * 快速排序，
 * 注意点：1.切分时，左边小于等于nums[k], 右边大于等于nums[k]
 *         2. 递归返回条件，2个相等时直接返回，所以lo >= hi
 *         3. 切分时退出条件，i >= j
 */
public class QuickSort {
    public void quickSort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int lo, int hi){
        if (lo >= hi){
            return;
        }
        int k;
        k = partation(nums, lo, hi);
        quickSort(nums, lo, k - 1);
        quickSort(nums, k + 1, hi);
    }

    private int partation(int[] nums, int lo, int hi){
        int i = lo;
        int j = hi + 1 ;
        while (true){
            while (nums[++i] < nums[lo]){
                if (i == hi){
                    break;
                }
            }
            while (nums[--j] > nums[lo]){
                if (j == lo){
                    break;
                }
            }
            if (i >= j){ //i,j 都指向一个元素等于 nums[lo]时，需要等于
                break;
            }
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }

    private void exch(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4,8,7,6,33,45,-1,-8,10};
        new QuickSort().quickSort(nums);
        for (int i : nums){
            System.out.println(i);
        }
    }
}
