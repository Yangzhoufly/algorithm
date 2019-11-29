package 牛客初级._07递归动态规划;

/**
 * 在一个数组中找数能否凑成和为aim
 * sum的可变范围是所有负数的和到所有正数的和
 * index的可变范围就是0到length+1
 */

public class _07arr_aim_sum_动态规划 {

    public static void main(String[] args) {
        int []arr={399,5,9,7};
        int aim=14;
        System.out.println(isSum_dp(arr,  aim));
    }
    private static boolean isSum_dp(int[] arr,int aim) {
        int lenX_index=arr.length+1;
        int lexY_sum=aim+1;
        boolean [][]dp=new boolean[lenX_index][lexY_sum];
        dp[arr.length][aim]=true;//对应basecase
        for(int i=lenX_index-2;i>=0;i--){
            for(int j=lexY_sum-1;j>=0;j--){
                dp[i][j]=  j+arr[i]<lexY_sum?   dp[i+1][j] || dp[i+1][j+arr[i]]   :   dp[i+1][j] ; //得到递推关系。
            }
        }
        return dp[0][0];
    }
}
