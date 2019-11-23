package 牛客初级._01排序;
import org.junit.Test;

/**
 * 分成三个区域，左边比num大，右边比num小，中间相等
 * https://www.jianshu.com/p/356604b8903f
 */
public class _08荷兰国旗问题 {


    //这里返回的是相等处的坐标

    public int[]  partition(int []arr,int num,int L,int R){
        int less=L-1;   //小于num的区域
        int more=R+1;     //大于num的区域，最右边
        int current=L;   //运行指针

        //有一个细节，就是与大的数交换，指针不移动，因为换回来的数是不确定的
        while(current<more){
            if(arr[current]<num){
                swap(arr,current++,++less);
            }else if(arr[current]>num){
                swap(arr,current,--more);
            }else{
                current++;
            }
            System.out.print(current+"   ;   ");
            printArray(arr);
        }
        return  new int[] { less + 1, more - 1 };

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
    public  void main0() {
        int[] test = {1,2,5,4,2,3,7,9,5,2,5,8,93,2,3,6};

        int res[]=partition(test, 5, 0, test.length-1);
        printArray(test);
        printArray(res);
    }

}


