package 剑指offer;

/**
 * 针对有序数组
 *二分法查找的时间复杂度O(logn)。
 */
public class _0二分法 {

    public static int binarySearch(int []nums,int target){
        if(nums == null  || nums.length==0){
            return -1;
        }
        int begin=0;
        int end=nums.length-1;
        int mid=0;

        while(begin<=end){
            mid=(begin+end)>>1;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                begin=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int []nums={1,2,3,4,5,6,7,8};
        System.out.println("index: "+binarySearch(nums, 3));
    }

}
