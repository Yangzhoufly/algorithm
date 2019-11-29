package 牛客初级._07递归动态规划;

/**
 * 在一个数组中找数能否凑成和为aim
 */


public class _07arr_aim_sum_递归 {

    public static void main(String[] args) {
        int []arr={2,3,5,7};
        int aim=102;
        System.out.println(isSum(arr, 0, 0, aim));
    }

    private static boolean  isSum(int[] arr, int index, int sum,int aim) {
        if(index==arr.length){
            return sum==aim;
        }
        return isSum(arr,index+1,sum,aim) || isSum(arr,index+1,sum+arr[index],aim);
    }
}
