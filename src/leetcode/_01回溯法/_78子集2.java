package leetcode._01回溯法;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用回溯法  https://leetcode-cn.com/problems/subsets/solution/hui-su-suan-fa-by-powcai-5/
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 1、所有子集
 */
public class _78子集2 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        traceBack(res, temp, nums, 0);
        return res;
    }

    private static void traceBack(List<List<Integer>> res, List<Integer> temp, int[] nums, int index) {
        res.add(new ArrayList<Integer>(temp));

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            traceBack(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {
        int []nums={1,2,3};
        System.out.println(subsets(nums));
    }
}
