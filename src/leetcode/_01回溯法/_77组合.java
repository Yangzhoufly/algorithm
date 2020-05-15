package leetcode._01回溯法;

import java.util.ArrayList;
import java.util.List;

/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

 */
public class _77组合 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 1 || k < 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        traceBack(res, temp, n, k, 0, 1);
        return res;
    }

    public static void traceBack(List<List<Integer>> res, List<Integer> temp, int n, int k, int num, int start) {
        if (num == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            traceBack(res, temp, n, k, num + 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}
