package jiuzhang.binarySearch;

/**
 * Created by fanjiangqi on 2017/5/31.
 * 二分查找的变形，找到第一个大于num的索引,找不到返回-1
 */
public class BinarySearch01 {
    //find the first number in minLast > nums[i]
    public int binarySearch(int[] minlast, int num){
        int lo = 0;
        int hi = minlast.length - 1;
        while (lo + 1 < hi){
            int mid = lo + (hi - lo) / 2;
            if (minlast[mid] < num){
                lo = mid;
            }else {
                hi = mid;
            }
        }
        if (minlast[lo] > num){
            return lo;
        }
        if (minlast[hi] > num){
            return hi;
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,10};
        System.out.println(new BinarySearch01().binarySearch(nums,1));
    }
}
