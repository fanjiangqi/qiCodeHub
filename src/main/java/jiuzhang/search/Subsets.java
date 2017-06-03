package jiuzhang.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanjiangqi on 2017/6/3.
 * 深度优先搜索的2个根本问题之一：subsets问题，回溯法，（模板，记住）
 * subsets问题一共有 2^n种情况
 * https://leetcode.com/problems/subsets/#/description
 * If nums = [1,2,3], a solution is:
        [
        [3],
        [1],
        [2],
        [1,2,3],
        [1,3],
        [2,3],
        [1,2],
        []
        ]
 *
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsetsHelper(nums, 0, res, new ArrayList<>());
        return res;
    }
    private void subsetsHelper(int[] nums, int pos, List<List<Integer>> res, List<Integer> list){
       // res.add(list);
        res.add(new ArrayList<>(list));
        for (int i = pos; i < nums.length; i++){
            list.add(nums[i]);
            subsetsHelper(nums, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
