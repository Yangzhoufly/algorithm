package 牛客初级._02其他;

import org.junit.Test;

/**
 * 【题目】 给定一个整型矩阵matrix,请按照转圈的方式打印它。
 * 例如:
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 打印结果为:1,2,3,4,8,12,16,15,14,13,9,5,6,7,11, 10
 * 【要求】 额外空间复杂度为O(1)。
 * lx,ly
 *
 *          rx,ry
 */
public class _18转圈打印矩阵 {
    public void printArr(int [][]arr){

        int rx=arr.length-1;
        int ry=arr[0].length-1;
        System.out.println(rx+""+ry);
        int lx=0;
        int ly=0;
        while(lx<=rx  &&  ly<=ry){
            printOne(arr,lx++,ly++,rx--,ry--);//打印一圈
        }


    }
    public void printOne(int [][]arr,int lx,int ly,int rx,int ry){
        if(lx==rx){
            for(int j=ly;j<=ry;j++){
                System.out.print(arr[lx][j]+" ");
            }
        }//只有一行
        else if(ly==ry){
            for(int i=lx;i<=rx;i++){
                System.out.println(arr[i][ly]+" ");
            }
        }//只有一列
        else{
            for(int j=ly;j<ry;j++){
                System.out.print(arr[lx][j]+" ");
            }
            for(int i=lx;i<rx;i++){
                System.out.print(arr[i][ry]+" ");
            }
            for(int j=ry;j>ly;j--){
                System.out.print(arr[rx][j]+" ");
            }
            for(int i=rx;i>lx;i--){
                System.out.print(arr[i][lx]+" ");
            }
        }//打印一个圈
    }

    @Test
    public void test(){
//        int [][]arr={{1,2,3,4},
//                     {5,6,7,8},
//                     {9,10,11,12},
//                     {13,14,15,16},
//                     {17,18,19,20}};

        int [][]arr={{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
//        printOne(arr,0,0,3,3);
        printArr(arr);
    }

}
