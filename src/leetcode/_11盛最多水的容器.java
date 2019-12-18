package leetcode;

public class _11盛最多水的容器 {
    public static  int maxArea(int[] height) {
        int res=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                res=Math.max(Math.min(height[i],height[j])*(j-i),res);
            }
        }
        return res;
    }

    /**
     * 别人的做法
     * @param height
     * @return
     */
    public static  int maxArea2(int[] height) {
        int res=0;
        int head=0;
        int tail=height.length-1;
        while(head!=tail){
            res=Math.max(Math.min(height[head],height[tail])*(tail-head),res);
            if(height[head]>height[tail]){
                tail--;
            }else{
                head++;
            }
        }
        return res;
    }

    public static  int maxArea3(int[] height) {
        int res=0;
        int head=0;
        int tail=height.length-1;
        while(head!=tail){
            res=height[head]>height[tail]?
                    Math.max(res,(tail-head)*height[tail--]):
                    Math.max(res,(tail-head)*height[head++]);
        }
        return res;
    }

    public static void main(String[] args) {
        int []arr={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea3(arr));
    }

}
