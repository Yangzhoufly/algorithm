package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
其实和我之前做两数和的第一种思路有点像，之前做两数和的时候，想到了先排序，再双指针收缩
该题：就这样解决。首先对数组排序，从头开始，先选定一个数，那么剩下的两个数岂不就是变成了之前的两数和的问题了。
还有重要的一点需要解决的是去重的问题
 */

public class _15三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 2) {
            return res;
        }

        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 为了去重
            int target = 0 - (nums[i]);
            int x = i + 1;
            int y = nums.length - 1;

            while (x < y) {
                if (x > i + 1 && nums[x] == nums[x - 1] && y < nums.length - 1 && nums[y] == nums[y + 1]) {
                    x++;
                    y--;
                    continue;
                }  // 为了去重
                if (nums[x] + nums[y] < target) {
                    x++;
                } else if (nums[x] + nums[y] > target) {
                    y--;
                } else {
                    temp.add(nums[i]);
                    temp.add(nums[x++]);
                    temp.add(nums[y--]);
                    res.add(new ArrayList<>(temp));
                    temp.clear();
                }
            }
        }
        return res;
    }

    @Test
    public void testFun() {
        int[] arr = {4, -2, 0, 4, 0, -5, 0};
        System.out.println(threeSum(arr));
    }
}
