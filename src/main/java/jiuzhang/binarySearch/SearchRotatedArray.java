package jiuzhang.binarySearch;

/**
 * Created by fanjiangqi on 2017/5/21.
 * 思路：利用二分法，要画图理解，先判断mid和nums[lo]之间的关系，再分为2个区域
 * https://leetcode.com/problems/search-in-rotated-sorted-array/#/description
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 *
 */
public class SearchRotatedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;
        int mid;

        while (lo + 1 < hi){
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] > nums[lo]){

                if(nums[mid] >= target && target >= nums[lo]){ // target 和nums[lo] 比较，画图理解，分为2个区域，同时target = nums[lo]也一定要包含
                    hi = mid;
                }else {
                    lo = mid;
                }
            } else {
                if (nums[mid] <= target && target <= nums[hi]){
                    lo = mid;
                }else {
                    hi = mid;
                }
            }
        }

        if(nums[lo] == target){
            return lo;
        }
        if(nums[hi] == target){
            return hi;
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4, 5, 6};
        int res = new SearchRotatedArray().search(nums, 5);
        System.out.println(res);
    }
}
