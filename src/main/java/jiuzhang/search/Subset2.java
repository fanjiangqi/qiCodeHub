package jiuzhang.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fanjiangqi on 2017/6/3.
 * Subsets 问题中添加重复元素，思路：先排序， 之后，相同的元素，如果前面一个没有使用，当前元素就跳过，不使用
 * https://leetcode.com/problems/subsets-ii/#/description
 */
public class Subset2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subsetWithDupHelper(res, new ArrayList<>(), nums, 0);

        return res;
    }

    private void subsetWithDupHelper(List<List<Integer>> res, List<Integer> list, int[] nums, int pos){
        res.add(new ArrayList<>(list));

        for (int i = pos; i < nums.length; i++){
            //相同的元素，如果前面一个没有使用，当前元素就跳过，不使用
            if (i > pos && nums[i] == nums[i - 1]){
                continue;
            }
            list.add(nums[i]);
            subsetWithDupHelper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
