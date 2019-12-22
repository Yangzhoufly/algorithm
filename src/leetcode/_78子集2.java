package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用回溯法
 */
public class _78子集2 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        traceBack(res,temp,nums,0);
        return res;
    }

    private static void traceBack(List<List<Integer>> res, List<Integer> temp, int[] nums, int index) {
        res.add(new ArrayList<Integer>(temp));

        for(int i=index ; i<nums.length ; i++){
            temp.add(nums[i]);
            traceBack(res,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }

    }


    public static void main(String[] args) {
        int []nums={1,2,3};

        System.out.println(subsets(nums));

        //List<List<Integer>> res = new ArrayList<>();
        //List<Integer> temp = new ArrayList<>();
        //temp.add(1);
        //res.add(temp);
        //System.out.println(res);
        //temp.add(2);
        //res.add(new ArrayList<>(temp));
        //System.out.println(res);
        //res.add(new ArrayList<>(temp));
        //System.out.println(res);

    }
}
