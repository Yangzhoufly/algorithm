package 牛客初级._01排序;

import org.junit.Test;

/**
 * 使用递归的方法求数组数组中的最大值
 */

public class _04递归求最大 {

    public int findMax(int []arr ,int start,int end){
        if(start==end){
            return arr[start];
        }
        int middle=(start+end)/2;
        int maxL=findMax(arr,start,middle);
        int maxR=findMax(arr,middle+1,end);

        return maxL>maxR ? maxL : maxR;
    }

    // for test
    @Test
    public  void maintest() {

        int []arr={0,1,2,3,4,5,6,5,2,6,4,1,56,2,6,2,5,4,1,2};
        System.out.println(findMax(arr, 0, arr.length-1));
    }


}
