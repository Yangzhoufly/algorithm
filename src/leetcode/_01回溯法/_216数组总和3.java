package leetcode._01回溯法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: k = 3, n = 7
输出: [[1,2,4]]

 */
public class _216数组总和3 {

    /*
    k 个数 的 和为n
组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     */

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n <= 0) {
            return res;
        }
        int[] candidates = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> temp = new ArrayList<>();
        traceBack(candidates, res, temp, n, 0, 0, k);
        return res;
    }


    public void traceBack(int[] candidates, List<List<Integer>> res, List<Integer> temp, int target, int curSum, int startIndex, int maxSize) {
        if (curSum == target && temp.size() == maxSize) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (temp.size() >= maxSize) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] + curSum > target) {
                return;
            }
            temp.add(candidates[i]);
            traceBack(candidates, res, temp, target, curSum + candidates[i], i + 1, maxSize);
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    public void testFun() {
        int k = 3, n = 9;
        List<List<Integer>> lists = combinationSum3(3, 9);
        System.out.println(lists);
    }

}
