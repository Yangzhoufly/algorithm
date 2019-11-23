package 牛客初级._01排序;

import org.junit.Test;

/**
 * 插入排序（Insertion sort） 简单、稳定  的排序算法。
 *
 * 联想打牌排序
 *
 *每一步都将一个待排数据按其大小插入到已经排序的数据中的适当位置，直到全部插入完毕。
 *
 *和数据状况有关系
 * 1、2、3、4、5  -》O(n) 有序
 * 5、4、3、2、1  -》O(n^2) 逆序
 *
 * 按照最差情况来讲   ： 插入排序  时间复杂度O(n^2) ；额外空间复杂度O(1)
 */

public class _03插入排序 {

    public void swap(int[] arr ,int i,int j){
        if(i>arr.length-1 || j>arr.length-1 ){
            return;
        }    //超出范围
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


    public void insertionSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        //从index为1的元素开始，因为第0个就一个数
        for (int i = 1; i < arr.length; i++) {

            //往前插入到对应的位置
            for (int j = i - 1; j >= 0; j--) {

                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                } else {
                    break;
                }
            }
            for (int i1 = 0; i1 < arr.length; i1++) {
                System.out.print(arr[i1] + ", ");
            }
            System.out.println();
        }
    }

    @Test
    public void insertionSortTest() {
        int[] arr = {2, 1, 5, 6, 9, 4};
        insertionSort(arr);

    }

}
