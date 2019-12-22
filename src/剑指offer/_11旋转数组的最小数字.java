package 剑指offer;

public class _11旋转数组的最小数字 {


    public  static int minNumberInRotateArray(int [] array) {
        if(array == null || array.length ==0){
            return Integer.MIN_VALUE;
        }

        int pre=0;
        int post=array.length-1;
        int mid=0;

        while(array[pre]>=array[post]){
            if(post-pre==1){
                return array[post];
            }
            mid=(post+pre)>>1;
            //
            if(array[pre]==array[mid] && array[post]==array[mid]){
                int min=Integer.MAX_VALUE;
                for(int i=pre;i<=post;i++){
                    min=array[i]<min?array[i]:min;
                }
                return min;
            }
            //中间点位于前一部分
            if(array[mid]>=array[pre]){
                pre=mid;
            }else if(array[mid]<=array[post]){
                post=mid;
            }
        }
        return array[mid];

    }
    public static void main(String[] args) {
        int []arr1={3,4,5,1,2};
        int []arr2={1,0,1,1,1};
        int []arr3={0,1,2,3,4};

        System.out.println(minNumberInRotateArray(arr1));
        System.out.println(minNumberInRotateArray(arr2));
        System.out.println(minNumberInRotateArray(arr3));

    }
}
