package jiuzhang.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanjiangqi on 2017/6/3.
 * 深度优先搜索的2个根本问题之一：permutations问题，回溯法，（模板，记住）
 * permutations 问题总共有 n! 种情况
 * https://leetcode.com/problems/permutations/#/description
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permutaHelper(res, new ArrayList<Integer>(), nums);

        return res;
    }

    private void permutaHelper(List<List<Integer>> res, List<Integer> list, int[] nums){
        if (list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if (list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            permutaHelper(res, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
