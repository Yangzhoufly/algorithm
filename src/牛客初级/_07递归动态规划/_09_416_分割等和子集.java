package 牛客初级._07递归动态规划;

/**
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class _09_416_分割等和子集 {


    public static void main(String[] args) {
        int []arr1={1,5,11,5};
        int []arr2={1,2,3,5};

        System.out.println(canPartition(arr1));
        System.out.println(canPartition(arr2));

    }

    public static  boolean canPartition(int[] arr) {
        int sum=0;
        for (int each : arr) {
            sum+=each;
        }
        if (sum%2!=0) return false;//和为偶数奇数直接返回
        int target=sum/2;
        //return process(arr,target,0,0);
        return dp_process(arr,target);
    }


    private static  boolean dp_process(int[] arr,int target) {
        int lenX_index=arr.length+1;
        int lenY_sum=target+1;
        boolean [][]dp=new boolean[lenX_index][lenY_sum];
        for (int i=0;i<lenX_index-1;i++ ) dp[i][target]=true;
        for(int i=lenX_index-2;i>=0;i--){
            for(int s=lenY_sum-2;s>=0;s--){
                boolean choose=s+arr[i]<=target ? dp[i+1][s+arr[i]]  : false;
                boolean notChoose= dp[i+1][s];
                dp[i][s]=choose||notChoose;
            }
        }
        return dp[0][0];
    }

    private static  boolean process(int[] arr,int target ,int index,int sum) {
        if(index==arr.length){
            return false;
        }
        if(sum==target){
            return true;
        }
        boolean choose=process( arr, target , index+1, sum+arr[index]);
        boolean notChoose=process( arr, target , index+1, sum);
        return choose||notChoose;
    }



}
