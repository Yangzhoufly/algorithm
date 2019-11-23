package 牛客初级._02其他;
import java.awt.*;

/**
 * 1  2  3  4
 * 5  6  7  8
 * 9 10 11 12
 * 13 14 15 16
 *
 * 打印为：1 2 5 9 6 3 4 7 10 13 14 11 8 12 15 16
 *思路：是一个宏观调度的问题，这顶标志进行约束
 * (A,B) ()
 * ()    ()
 *
 * ()  (A)
 * (B)  ()
 *
 * A向右走，走到最右边后往下移动
 * B往下走，走到最下之后往右移动
 * 这样，AB之间就连成了一条线，打印这一条线
 *->y
 *
 * x
 */
public class _19之字形打印矩阵 {

    public static void printZhi(int [][]arr){
        Point A = new Point(0,0);
        Point B = new Point(0, 0);

        while(true){
            boolean upPrint=(A.x+A.y)%2==0?true:false; //确定打印方向
            printXie(arr, A, B,upPrint);//斜着打印
            if(A.y<arr[0].length-1){
                A.y=A.y+1;
            }else{
                A.x=A.x+1;
            }//更新A的坐标
            if(B.x< arr.length-1){
                B.x=B.x+1;
            }else{
                B.y=B.y+1;
            }//更新B的坐标

            if(B.x==arr.length-1 && B.y==arr[0].length-1){
                System.out.println(arr[B.x][B.y]);
                System.out.println("end");
                break;
            }//终止条件

        }


    }
    //斜着打印的方法
    public static void printXie(int [][]arr,Point A,Point B,boolean upPrint){
        if(upPrint==true){
            int x=B.x;
            int y=B.y;
            while(x>=0 && y<arr[0].length){
                System.out.print(arr[x--][y++]);
                System.out.print(" ");
            }
        }
        if(upPrint==false){
            int x=A.x;
            int y=A.y;
            while(x<arr.length && y>=0){
                System.out.print(arr[x++][y--]);
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        int [][] arr=
                {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
//        System.out.println(arr[0][1]);
        printZhi(arr);
    }

}
