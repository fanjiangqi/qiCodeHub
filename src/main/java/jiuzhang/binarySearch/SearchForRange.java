package jiuzhang.binarySearch;

/**
 * Created by fanjiangqi on 2017/5/21.
 * 思路：二分查找找到第一个相同的位置，二分查找找到最后一个相同的位置
 * https://leetcode.com/problems/search-for-a-range/#/description
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class SearchForRange {

    public int[] searchRange(int[] nums, int target) {

        int[] bounds = new int[2];
        if (nums.length == 0){
            bounds[0] = bounds[1] = -1;
            return bounds;
        }
        int lo = 0;
        int hi = nums.length - 1;
        int mid;

        while (lo + 1 < hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] == target){
                hi = mid;
            }else if (nums[mid] < target){
                lo = mid;
            }else{
                hi = mid;
            }
        }
        if (nums[lo] == target){
            bounds[0] = lo;
        }else if (nums[hi] == target){
            bounds[0] = hi;
        }else{
            bounds[0] = bounds[1] = -1;
            return bounds;
        }

        lo = 0;
        hi = nums.length - 1;
        while(lo + 1 < hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] == target){
                lo = mid;
            }else if (nums[mid] < target){
                lo = mid;
            }else{
                hi = mid;
            }
        }
        if (nums[hi] == target){
            bounds[1] = hi;
        }else if (nums[lo] == target){
            bounds[1] = lo;
        }else{
            bounds[0] = bounds[1] = -1;
            return bounds;
        }
        return bounds;
    }
}
