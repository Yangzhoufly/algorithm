package leetcode;

public class _33搜索旋转排序数组2 {

    public static int search(int[] nums, int target) {
        if(nums==null || nums.length==0 ||(nums[0]>target && nums[nums.length-1]<target)){
            return -1;
        }
        if(nums.length==1){
            return nums[0]==target?0:-1;
        }
        int pre=0;
        int post=nums.length-1;
        int mid=0;
        while(nums[pre]>nums[post]){
            mid=(pre+post)>>1;
            if(post-pre == 1){
                mid=pre;
                break;
            }
            if(nums[mid] >= nums[pre]){
                pre=mid;
            }else{
                post=mid;
            }
        }

        //System.out.println("mid: "+mid);
        pre=0;
        post=nums.length-1;
        if(target>=nums[pre] && target <= nums[mid]){
            //System.out.println("left");
            return binarySearch(nums,target,pre,mid);
        }else if(target>=nums[mid +1] && target <= nums[post]){
            //System.out.println("ringht");
            return binarySearch(nums,target,mid +1,post);
        }
        return -1;
    }

    public static int binarySearch(int []nums,int target,int pre,int post){
        if(nums == null  || nums.length==0){
            return -1;
        }
        int begin=pre;
        int end=post;
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
        int []nums={4};
        //int []nums={0};
        int target=0;
        System.out.println(search(nums, target));
    }


}
