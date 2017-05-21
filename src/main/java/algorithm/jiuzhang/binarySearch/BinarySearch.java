package algorithm.jiuzhang.binarySearch;

/**
 * Created by fanjiangqi on 2017/5/21.
 * 九章算法给出的二分查找的模板
 * 题目：找出数组num中第一个target，返回索引值， 如果不存在返回 -1
 */
public class BinarySearch {
    public int binarySearch(int[] num, int target){
        int lo = 0;
        int hi = num.length - 1;
        int mid;

        while (lo + 1 < hi){  //此处循环终此条件是重点
            mid = lo + (hi - lo) / 2;
            if (num[mid] == target){
                hi = mid;
            } else if (num[mid] < target){
                lo = mid;       //此处 不需要lo = mid + 1 方便记忆
            } else {
                hi = mid;       //同上
            }
        }
        if (num[lo] == target)
            return lo;
        if (num[hi] == target){
            return hi;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,5,5,6,7,8};
        int[] nums1 = {2,2};
        int res = new BinarySearch().binarySearch(nums1, 2);
        System.out.println(res);
    }
}
