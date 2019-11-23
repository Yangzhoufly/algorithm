package 牛客初级._02其他;


import java.awt.*;

/**
 * 要求实现的复杂度为O(n+m)
 *在行列都排好序的矩阵中找数
 * 【题目】 给定一个有N*M的整型矩阵matrix和一个整数K,
 * matrix的每一行和每一 列都是排好序的。实现一个函数,判断K
 * 是否在matrix中。 例如:
 * 0 1 7 7
 * 2 3 7 7
 * 4 4 7 8
 * 5 7 7 9 如果K为7,返回true;如果K为6,返
 * 回false。
 * 【要求】 时间复杂度为O(N+M),额外空间复杂度为O(1)。
 *
 *【思路】从右上角   或者  左下角  开始寻找
 * 左下角为例：5->7->4->4->4->2->5->false
 *
 */
public class _18矩阵中找数 {

    public static void findNum(int [][]arr,int num){

        Point leftDown = new Point(arr.length - 1, 0);//从左下角开始

        while(true){
            int temp=arr[leftDown.x][leftDown.y];

            if(temp==num){
                System.out.println("find: "+num);
                break;
            }else if(temp<num){   //小于，往右
                System.out.print(temp+" -> ");
                leftDown.y+=1;
                if(leftDown.y>arr[0].length-1){
                    System.out.println("end,not found");
                    break;
                }

            }else{   //大于，往上
                System.out.print(temp+" -> ");
                leftDown.x-=1;
                if(leftDown.x<0){
                    System.out.println("end,not found");
                    break;
                }

            }

        }
    }





    public static void main(String[] args) {
        int [][] arr=
                       {{0,1,7,7},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};
        int [][]arr2=
                       {{1,2,3,4},
                        {2,3,7,7},
                        {4,4,7,8},
                        {5,7,7,9}};
        int [][]arr3=
                       {{1,2,7,7},
                        {2,3,7,7},
                        {4,4,7,8},
                        {5,7,7,9}};
//        System.out.println(arr[0][1]);
        findNum(arr,4);
        findNum(arr2,6);
        findNum(arr3,6);
    }


}
