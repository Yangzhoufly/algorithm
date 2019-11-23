package 牛客初级._01排序;

import org.junit.Test;

/**
 * 归并（merge--合并）排序
 * 先对左边排序、再对右边排序，再把左右排好序的结果整体排序
 *
 * https://www.jianshu.com/p/33cffa1ce613
 *
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(N)，归并排序需要一个与原数组相同长度的数组做辅助来排序
 * 稳定性：归并排序是稳定的排序算法，
     temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
     这行代码可以保证当左右两部分的值相等的时候，先复制左边的值，这样可以保证值相等的时候两个元素的相对位置不变。
 */

public class _05mergeSort {

    //归并排序
    public void mergeSortFun(int []arr){
        if(arr==null||arr.length<2){
            return;
        }
        mergeSort(arr,0, arr.length-1);
    }

    //L和R代表index
    public void mergeSort(int []arr,int L,int R){
        if(L==R){
            return;
        }
        int mid=(L+R)/2;
        mergeSort(arr,L,mid);     //对左边排序
        mergeSort(arr,mid+1,R);//对右边排序
        merge(arr,L,mid,R);         //左右结合在一块儿排序
    }


    public void merge(int []arr,int L,int mid,int R){
        if(arr==null){
            return;
        }
        int []temp=new int[R-L+1];//创建一个辅助数组
        int point=0;              //指向辅助数组的头部
        int p1=L;                 //指向左边排好序的头部
        int p2=mid+1;             //指向右边排好序的头部

        //将arr中的数据按大小放入辅助数组
        while(p1<=mid && p2<=R){
            temp[point++]=arr[p1]>arr[p2]?arr[p2++]:arr[p1++];
        }

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
    }

    @Test
    public void test1(){

        int []arr={1,2,5,4,2,3,7,9,5,2,5,8,93,2,3,6};

        mergeSortFun(arr);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
