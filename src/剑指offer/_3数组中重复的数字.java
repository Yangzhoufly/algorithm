package 剑指offer;

/**
 * 使用二分法将1-n分为两个区间进行查找
 */
public class _3数组中重复的数字 {

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
            int countRight=0;
            for (int num : nums) {
                if(num>=begin && num<=mid){
                    countLeft++;
                }else if(num>=mid+1 && num<=end){
                    countRight++;
                }
            }
            System.out.println("["+begin+" "+ mid +"]"+","+"["+(mid+1)+" "+ end +"]");
            System.out.println(countLeft+"  "+ countRight);

            //如果左边满足重复条件
            if(countLeft > mid-begin+1){
                end=mid;
            }else if(countRight > end - (mid+1) +1){
                begin=mid+1;
            }

            if(begin==end){
                return begin;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        int []arr={2,3,5,4,1,2,6,7};

        System.out.println(getDuplication(arr));

    }
}
