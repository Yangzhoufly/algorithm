package leetcode._01回溯法;

import java.util.ArrayList;
import java.util.List;

/*
给定一个没有重复数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return

    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
 */
public class _46全排列 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int len = nums.length;

        traceBack(res, temp, nums, len);

        return res;
    }

    public static void traceBack(List<List<Integer>> res, List<Integer> temp, int[] nums, int len) {
        if (temp.size() == len) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!temp.contains(nums[i])) {
                temp.add(nums[i]);
                traceBack(res, temp, nums, len);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        int [] arr={1,2,3};
        System.out.println(permute(arr));
    }
}
