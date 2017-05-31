package jiuzhang.dp;

/**
 * Created by fanjiangqi on 2017/5/31.
 * 求连续子数组最大和
 * 思路：f[i]（表示前i个数中）以第i个结尾的连续子数组最大和，
 *      f[i] = f[i-1] + A[i],  f[i-1] >= 0
 *           = A[i]         ,  f[i-1] < 0
 *       初始化f[0] = A[0]
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaxSubarray {
    public int maxSubArray(int[] nums) {

        int[] f = new int[nums.length]; //（表示前i个数中）以第i个结尾的连续子数组最大和
        f[0] = nums[0];
        int max = f[0];
        for (int i = 1; i < nums.length; i++){
            if (f[i - 1] < 0){
                f[i] = nums[i];
            }else {
                f[i] = f[i - 1] + nums[i];
            }
            if (f[i] > max){
                max = f[i];
            }
        }

        return max;
    }
}
