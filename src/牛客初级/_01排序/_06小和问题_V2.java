package 牛客初级._01排序;

import org.junit.Test;

/**
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。
 * 例子：
 * [1,3,4,2,5]
 * 1左边比1小的数，没有；
 * 3左边比3小的数，1；
 * 4左边比4小的数，1、3；
 * 2左边比2小的数，1；
 * 5左边比5小的数，1、3、4、2；
 * 所以小和为1+1+3+1+1+3+4+2=16
 *
 * 思路：用分制算法
 */
public class _06小和问题_V2 {

    public int smallSum(int []arr){
        if(arr==null || arr.length<2){
            return 0;
        }
       return smallSumMerge(arr,0,arr.length-1);
    }
    public int smallSumMerge(int []arr,int L,int R){
        if(L==R){
            return 0;  //注意这里
        }
        int mid=L+((R-L)>>1);
//        int mid=(L+R)/2;

        return smallSumMerge(arr,L,mid)
                + smallSumMerge(arr,mid+1,R)
                + mergeSum(arr,L,mid,R);
    }
    public int mergeSum(int []arr,int L,int mid,int R){
        int p1=L;
        int p2=mid+1;
        int[]temp=new int[R-L+1];
        int point=0;//指向辅助数组的头部
        int currentSum=0;
//        for(int i=L;i<=R;i++){
//            System.out.print(arr[i]);
//            if(i==mid){
//                System.out.print("     ");
//            }
//        }
        while(p1<=mid && p2<=R){
            currentSum+=arr[p1]<arr[p2]?arr[p1]*(R-p2+1):0;
            temp[point++]=arr[p1]>=arr[p2]?arr[p2++]:arr[p1++];
        }

//        System.out.print("    "+currentSum+"\n");

        //将剩下的数据放入辅助数组
        while(p1<=mid){
            temp[point++]=arr[p1++];
        }
        while(p2<=R){
            temp[point++]=arr[p2++];
        }
        //将辅助数组中的值放回原始的arr
        for(int i=0;i<temp.length;i++){
            arr[L++]=temp[i];
        }
        return currentSum;
    }

    @Test
    public void test(){
        int []arr={1,3,4,2,5};
        System.out.println("小和为：  "+smallSum(arr));
    }



    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    @Test
    public  void main1() {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (smallSum(arr1) != comparator(arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}
