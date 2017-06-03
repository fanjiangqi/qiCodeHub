package jiuzhang.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fanjiangqi on 2017/6/3.
 * permutations 问题，有重复的，核心解决方案：boolean[] used数组
 * 当一个数和前面一个数相等时，只有前面一个数用过，才能使用这个数
 * https://leetcode.com/problems/permutations-ii/#/description
 */
public class Permutation2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        permutaHelper(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);

        return res;
    }

    private void permutaHelper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used){
        if (list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if (used[i]){
                continue;
            }
            //when a number has the same value with its previous, we can use this number only if his previous is used
            //当一个数和前面一个数相等时，只有前面一个数用过，才能使用这个数
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            permutaHelper(res, list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
