package leetcode._01回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
剪枝画图： https://leetcode-cn.com/problems/subsets-ii/solution/hui-su-jian-zhi-by-norazh/
 */
public class _90子集 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //排序很关键、用于剪枝
        Arrays.sort(nums);

        traceBack(res, temp, nums, 0);
        return res;
    }

    public static void traceBack(List<List<Integer>> res, List<Integer> temp, int[] nums, int index) {
        res.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            //在index之后，如果和排序结果的前一个相同，就需要剪枝。相当于每一层只取了不同的数加入temp
            if ((i > index) && (nums[i] == nums[i - 1])) {
                continue;
            }
            temp.add(nums[i]);
            traceBack(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,2,2,4,4,4};
        System.out.println(subsetsWithDup(arr));
    }
}
