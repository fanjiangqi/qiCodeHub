package algorithm;

/**
 * Created by fanjiangqi on 2017/5/22.
 * 归并排序，先局部有序，再整体有序
 * 提醒：没看书本居然没写出来
 */
public class MergeSort {
    public void mergeSort(int[] nums){

        mergeSort(nums,0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int lo, int hi){
        if (lo >= hi){
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi){
        int[] cur = new int[nums.length];
        int k;
        for (k = lo; k <= hi; k++){
            cur[k] = nums[k];
        }
        int i = lo;
        int j = mid + 1;
        for (k = lo; k <= hi; k++ ){
            if (i > mid){
                nums[k] = cur[j++];
            }else if (j > hi){
                nums[k] = cur[i++];
            }else if (cur[j] < cur[i]){
                nums[k] = cur[j++];
            }else {
                nums[k] = cur[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,8,7,6,33,45,-1,-8,10};
        new MergeSort().mergeSort(nums);
        for (int i : nums){
            System.out.println(i);
        }
    }
}
