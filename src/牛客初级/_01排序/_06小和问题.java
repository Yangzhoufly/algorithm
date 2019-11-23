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
public class _06小和问题 {

    public static int sum=0;
    public int smallSum(int []arr){
        if(arr==null || arr.length<2){
            return 0;
        }
       return smallSumMerge(arr,0,arr.length-1);
    }

    public int smallSumMerge(int []arr,int L,int R){
        if(L==R){
            return arr[L];
        }
        int mid=(L+R)/2;
        smallSumMerge(arr,L,mid);
        smallSumMerge(arr,mid+1,R);
        sum=sum+getSum(arr,L,mid,R);
        return sum;
    }
    public int getSum(int []arr,int L,int mid,int R){
        int p1=L;
        int p2=mid+1;
        int[]temp=new int[R-L+1];
        int point=0;//指向辅助数组的头部
        int currentSum=0;

        for(int i=L;i<=R;i++){
            System.out.print(arr[i]);
            if(i==mid){
                System.out.print("     ");
            }
        }

        while(p1<=mid && p2<=R){
            if(arr[p1]>=arr[p2]){
                temp[point++]=arr[p2++];
            }else {
                currentSum=currentSum+arr[p1]*(R-p2+1);//新的小和，乘以(R-p2+1)，是因为后半部分是排好序的，比这个小，肯定比后边的小
                temp[point++]=arr[p1++];
            }
        }

        System.out.print("    "+currentSum+"\n");

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

}
