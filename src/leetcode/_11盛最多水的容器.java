package leetcode;

import org.junit.Test;

import java.util.ArrayList;

public class _11盛最多水的容器 {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        int i = 0;
        int j = height.length - 1;
        int cap = 0;
        while (i < j) {
            cap = Math.max(Math.min(height[i], height[j]) * (j - i), cap);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return cap;
    }

    @Test
    public void testFun() {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
    }

}
