package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90子集 {


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length == 0 || nums == null){
            return res;
        }
        Arrays.sort(nums);
        List<Integer> temp=new ArrayList<>();
        traceBack( res, temp, nums,0 );
        return res;
    }

    public void traceBack(List<List<Integer>> res, List<Integer> temp,int[] nums,int index){
        if(!res.contains(temp)){
            res.add(new ArrayList(temp));
        }

        for(int i = index ; i < nums.length ; i++){
            temp.add(nums[i]);
            traceBack( res, temp, nums,i+1 );
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        int []arr={2,2,4,1,4,4,4};
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
