package leetcode._01回溯法;

import org.junit.Test;

import java.awt.event.TextEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。
说明：
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:
输入: candidates = [2,3,6,7], target = 7,

所求解集为:
[
  [7],
  [2,2,3]
]
 */
public class _39组合总和 {
    /*
    注意对数据排序 + 标记每一次的起始位置，避免往回遍历
     */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        traceBack(candidates, res, temp, target, 0, 0);
        return res;

    }

    public void traceBack(int[] candidates, List<List<Integer>> res, List<Integer> temp, int target, int curSum, int startIndex) {
        if (curSum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (curSum + candidates[i] > target) {
                break;
            }
            temp.add(candidates[i]);
            traceBack(candidates, res, temp, target, curSum + candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    public void testFun() {
        int[] candidates = new int[]{1, 2, 5};
        int target = 5;
        List<List<Integer>> lists = combinationSum(candidates, target);
        System.out.println(lists);
    }
}
