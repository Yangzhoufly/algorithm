package 牛客初级._01排序;

import org.junit.Test;

import java.util.Arrays;

/**
 * 冒泡排序（Bubble Sort）
 *	时间复杂度O(N^2)，额外空间复杂度O(1)
 *
 * 2, 1, 5, 6, 9, 4
 * 1, 2, 4, 5, 6, 9,
 *
 * 1、算法思想
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */

public class _01冒泡 {


    @Test
    public void swapTest(){
        int[] arr={0,1,2,3,4};
        swap(arr,2,1);
        for (int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

    public void swap(int[] arr ,int i,int j){
        if(i>arr.length-1 || j>arr.length-1 ){
            return;
        }    //超出范围
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


    public  void bubbleSort(int[] arr){

        if(arr==null || arr.length<2){
            return;
        }

        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }

    }

    @Test
    public void bubbleSortTest() {
        int[] arr = {2, 1, 5, 6, 9, 4};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }




    // for test   绝对正确的方法
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test  产生随机数组   数组长度随机  值随机
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];//数组长度随机
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test   拷贝数组
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test   判断数组是否相等
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test   打印数组
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }



    // for test  用大样本进行测试
    @Test
    public  void maintest() {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr_init= copyArray(arr1);

            //这里输入需要测试的方法
            bubbleSort(arr1);
            comparator(arr2);   //绝对正确的方法

            if (!isEqual(arr1, arr2)) {
                succeed = false;
                System.out.println("原始：");
                printArray(arr_init);
                System.out.println("正确：");
                printArray(arr2);
                System.out.println("我的：");
                printArray(arr1);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }



}
