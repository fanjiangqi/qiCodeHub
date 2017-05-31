package jiuzhang.dp;

/**
 * Created by fanjiangqi on 2017/5/31.
 */
public class LIS {
    public int lengthOfLIS(int[] nums) {

        int[] f = new int[nums.length];//f[i]表示前i个元素中以第i个结尾的LIS的长度
        int max = 0; //同时解决了 nums.length = 0的情况
        for (int i = 0; i < nums.length; i++){
            f[i] = 1;//初始化
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    f[i] = f[i] > f[j] + 1 ? f[i] : f[j] + 1;  //function 状态转换
                }
            }
            if (f[i] > max){
                max = f[i];
            }
        }

        return max;
    }

    /**
     * nlogn 复杂度,使用二分查找
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        //表示LIS长度为i的序列结尾的，最小的那个元素是minlast[i]
        int[] minlast = new int[nums.length + 1];
        //初始化
        minlast[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length ; i++ ){
            minlast[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < nums.length; i ++){
            //find the first number in minLast > nums[i]
            int index = binarySearch(minlast, nums[i]);
            minlast[index] = nums[i];
        }
        for (int i = nums.length; i >= 0; i--){
            if (minlast[i] != Integer.MAX_VALUE){
                return i;
            }
        }
        return 0;
    }

    //find the first number in minLast > nums[i]
    private int binarySearch(int[] minlast, int num){
        int lo = 0;
        int hi = minlast.length - 1;
        while (lo + 1 < hi){
            int mid = lo + (hi - lo) / 2;
            if (minlast[mid] >= num){
                hi = mid;
            }else {
                lo = mid;
            }
        }
        if (minlast[lo] > num){
            return lo;
        }
        return hi;

    }
}
