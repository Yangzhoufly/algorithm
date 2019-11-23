package 牛客初级._01排序;

import org.junit.Test;
import java.util.Arrays;

public class _10堆排序_Vmy01 {


    public  void heapSort(int[] arr) {
        if(arr==null || arr.length<2){
            return ;
        }
        for(int i=0;i<arr.length;i++){
            heapInsert(arr,i);
        }
        int size = arr.length;
        swap(arr,0,--size);
        for(int i=arr.length-2;i>0;i--){
            heapify(arr,0,i);
            swap(arr,0,i);   //注意这一步不要遗忘了
        }
    }

    @Test
    public void tests(){
        int [] arr={1,2,5,4,2,3,7,9,5};
        heapSort(arr);
        printArray(arr);
    }



    /**
     * 大根堆：父节点比子节点大，也就是根节点是树的最大
     * 形成大根堆，末尾大的数往上走
     */
    public  void heapInsert(int[] arr, int index) {

        while(arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index=(int)(index-1)/2;
        }

    }


    public  void heapify(int[] arr, int index, int lastIndex) {
        while(2*index+1<=lastIndex){
            int largestSunIndex=((2*index+2)>lastIndex)||arr[2*index+1]>arr[2*index+2] ? 2*index+1 :2*index+2;
            int largestIndex=arr[largestSunIndex]>arr[index]?largestSunIndex:index;
            if(largestIndex==index){
                break;
            }else{
                swap(arr,index,largestIndex);
                index=largestIndex;
            }
        }

    }

    public  void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public  void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public  int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public  int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public  boolean isEqual(int[] arr1, int[] arr2) {
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
    public  void tets() {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }
}
