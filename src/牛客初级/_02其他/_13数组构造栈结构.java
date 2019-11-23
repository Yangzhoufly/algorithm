package 牛客初级._02其他;

import org.junit.Test;

/**
 * 先进后出
 */
public class _13数组构造栈结构 {

    public static  int point=-1;

    public boolean isPopSafe(int []arr){
        if(point<0||arr==null){
            System.out.println("到达数组下界");
            return false;
        }
        return true;
    }

    public boolean isPushSafe(int []arr){
        if(point>=2||arr==null){
            System.out.println("到达数组上届");
            return false;
        }
        return true;
    }


    public void push(int []arr,int num){
        if(isPushSafe(arr)){
            arr[++point]=num;   //point加了之后在填入元素
        }else{
            return;
        }
//        printArray2(arr);
        System.out.print("push之后：   ");
        printArray(arr);
    }


    public void pop(int []arr){
        if(isPopSafe(arr)){
            System.out.println("pop的元素是：  "+arr[point--]);  //pop了元素之后再网后退
        }else{
            return;
        }
        System.out.print("pop之后：   ");
        printArray(arr);
    }

    @Test
    public void test0(){
        int []arr=new int[3];
        push(arr,7);
        push(arr,2);
        push(arr,53);
        push(arr,6);
        pop(arr);
        pop(arr);
        pop(arr);
        pop(arr);
    }





    // for test
    public  void printArray(int[] arr) {
        if (arr == null || point<0) {
            return;
        }
        for (int i = 0; i < point+1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}
