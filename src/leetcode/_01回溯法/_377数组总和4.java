package leetcode._01回溯法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
这道题不能使用递归了，得改用动态规划
返回组合子集排列使用回溯，返回值使用动态规划

给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。

示例:

nums = [1, 2, 3]
target = 4

所有可能的组合为：
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

 */
public class _377数组总和4 {
    public int combinationSum4_old(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] res = new int[1];
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);

        traceBack(nums, res, temp, target, 0);
        return res[0];
    }

    public void traceBack(int[] nums, int[] res, List<Integer> temp, int target, int curSum) {
        if (curSum == target) {
            res[0]++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (curSum + nums[i] > target) {
                break;
            }
            temp.add(nums[i]);
            traceBack(nums, res, temp, target, curSum + nums[i]);
            temp.remove(temp.size() - 1);
        }
    }
/*
由于只要求输出数字，并不求具体的分配情况，所以可以使用动态规划
 */

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int each : nums) {
                if (i - each >= 0) dp[i] += dp[i - each];
            }
        }
        return dp[target];
    }



    @Test
    public void testFun() {
        int[] nums = new int[]{1, 2, 5};
        int target = 5;
        int lists = combinationSum4(nums, target);
        System.out.println(lists);
    }
}
