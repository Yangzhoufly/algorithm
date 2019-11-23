package 牛客初级._01排序;

import org.junit.Test;

/**
 * 选择排序（Selection sort）  O(N^2)  不稳定
 *
 * 6, 1, 5, 2, 9, 4
 * 1, 2, 4, 5, 6, 9,
 *
 *
 * 工作原理是每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到全部待排序的数据元素排完。 选择排序是不稳定的排序方法。
 *
 *
 * 第1趟从R[0]~R[n-1]中选取最小值，与R[0]交换；
 * 第2趟从R[1]~R[n-1]中选取最小值，与R[1]交换；
 * 第i趟从R[i-1]~R[n-1]中选取最小值，与R[i-1]交换；
 */
public class _02选择排序 {

    public void swap(int[] arr, int i, int j) {
        if (i > arr.length - 1 || j > arr.length - 1) {
            return;
        }    //超出范围
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public void selectionSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        for (int startIndex = 0; startIndex < arr.length -1 ; startIndex++) {

            //1、记录初始下标
            int minIndex = startIndex;

            //2、寻找最小值
            for (int i = startIndex + 1; i < arr.length; i++) {
                if (arr[i] < arr[minIndex]) {
                    //修改最小值的下标
                    minIndex=i;
                }
            }
            //3、将找到的minIndex和startIndex处的数据交换
            swap(arr,startIndex,minIndex);
        }
    }

    @Test
    public void selectionSortTest(){
        int[] arr = {6, 1, 5, 2, 9, 4};
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }


}
