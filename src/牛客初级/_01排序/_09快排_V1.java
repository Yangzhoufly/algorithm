package 牛客初级._01排序;

import org.junit.Test;

/**
 * 根据荷兰国旗问题改编，大于放右边，小于放左边，等于放中间
 * 再对大于小于区域进行递归
 *
 * 经典快排，拿最后一个数作为基准，
 * 遇到顺序的序列，，1,2,3,4
 * 退化为O(n^2)
 */

public class _09快排_V1 {
    public void fastSort(int arr[],int L,int R){
        if(arr==null||arr.length<2||L>R){
            return;
        }
        int []res=partition(arr,L,R);
        fastSort(arr,L,res[0]-1);
        fastSort(arr,res[1]+1,R);
    }

    public int[]  partition(int []arr,int L,int R){
        /**
         * 可以改进省去变量num
         */
        int num=arr[R];   //将最后一个数作为比较基准，可以进一步省去这个变量，
        int less=L-1;     //小于num的区域
        int more=R+1;     //大于num的区域，最右边
        int current=L;   //运行指针
//有一个细节，就是与大的数交换，指针不移动，因为换回来的数是不确定的
        while(current<more){
            if(arr[current]<num){
                swap(arr,current++,++less);
            }else if(arr[current]>num){
                swap(arr,current,--more);
            }else{
                current++;  // 等于
            }
        }
        return  new int[] { less + 1, more - 1 };  //记录等于区域的范围
    }

    public void swap(int []arr,int i,int j){
        if(arr.length<2||i>arr.length||j>arr.length){
            System.out.println("交换出错");
            return ;
        }else{
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }


    // for test
    public  void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    @Test
    public  void main0() {
        int[] test = {1,2,5,4,2,3,7,9,5,2,5,8,93,2,3,6};
        printArray(test);
        fastSort(test, 0, test.length-1);
        printArray(test);
    }

}
