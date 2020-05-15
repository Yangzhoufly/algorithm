package leetcode._01回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
又是重复的，需要排序
 */
public class _47全排列2 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        Arrays.sort(nums);

        //用来标记是否用过该位置的数
        boolean[] used = new boolean[nums.length];

        int len = nums.length;

        traceBack(res, temp, nums, len, used);

        return res;
    }

    public static void traceBack(List<List<Integer>> res, List<Integer> temp, int[] nums, int len, boolean[] used) {

        if (temp.size() == len) {
            res.add(new ArrayList<>(temp));
            return;
        }
        //i > 0 && nums[i] == nums[i - 1] 是为了删除统一层中的重复选择
        //i > 0 && nums[i] == nums[i - 1] && !used[i - 1] 是为了保证往深处选择的第一个数是一定能选的

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                temp.add(nums[i]);
                traceBack(res, temp, nums, len, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        int [] arr={3,3,0,3};
        System.out.println(permuteUnique(arr));
    }
}
