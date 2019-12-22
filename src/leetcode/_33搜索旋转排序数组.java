package leetcode;

public class _33搜索旋转排序数组 {

    public static int search(int[] nums, int target) {
        if(nums==null || nums.length==0 ||(nums[0]>target && nums[nums.length-1]<target)){
            return -1;
        }
        int pre=0;
        int post=nums.length-1;

        while(pre<=post){
            int mid=(pre+post)>>1;
            System.out.println(pre+" "+mid+" "+post);

            if(target == nums[mid] ){
                return mid;
            }
            //只可能位于右边
            if(target > nums[mid]){
                pre=mid+1;
            }else{
                if(target >= nums[pre]){
                    post = mid -1;
                }else if( target <= nums[post]){
                    pre = mid + 1;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int []nums={4,5,6,7,0,1,2};
        //int []nums={0};
        int target=1;
        System.out.println(search(nums, target));
    }


}
