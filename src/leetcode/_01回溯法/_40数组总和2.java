package leetcode._01回溯法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。

说明：
所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:
输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 */
public class _40数组总和2 {



        /*
    candidates 中的每个数字在每个组合中只能使用一次。
     */

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (curSum + candidates[i] > target) {   //改进了一下，提前退出，不进入递归
                break;
            }
            if (i > startIndex && candidates[i] == candidates[i - 1]) {  //针对for循环的时候，1,1,2，连续相同的挨着的情况
                continue;
            }
            temp.add(candidates[i]);
            traceBack(candidates, res, temp, target, curSum + candidates[i], i + 1);//i + 1 表示每个数字只能选一次
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    public void testFun() {
        int[] candidates = new int[]{10,1,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        System.out.println(lists);
    }
}
