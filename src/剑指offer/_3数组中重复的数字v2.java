package 剑指offer;

/**
 * 使用二分法将1-n分为两个区间进行查找
 * 改进
 * 那么感觉之前的版本都是错的
 */
public class _3数组中重复的数字v2 {

    public static int getDuplication(int []nums){
        if(nums == null  || nums.length <= 1){
            return -1;
        }
        int begin=1;
        int end=nums.length-1;
        int mid=0;

        while(begin<=end){
            mid=(begin+end)>>1;
            int countLeft=0;
            for (int num : nums) {
                if(num>=begin && num<=mid){
                    countLeft++;
                }
            }

            System.out.println("["+begin+" "+ mid +"]"+","+"["+(mid+1)+" "+ end +"]");
            System.out.println(countLeft);


            if(begin==end ){
                if(countLeft >1){
                    return begin;
                }else{
                    break;
                }
            }

            //如果左边满足重复条件
            if(countLeft > mid-begin+1){
                end=mid;
            }else {
                begin=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int []arr={2,3,5,4,1,2,6,7};

        System.out.println(getDuplication(arr));

    }
}
