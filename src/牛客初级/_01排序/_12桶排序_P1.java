package 牛客初级._01排序;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定一个数组,求排序之后,相邻两数的最大差值,要求时
 * 间复杂度O(N),且要求不能用 非基于比较的排序。
 *
 * 借鉴桶排序的思想，n个数创建n+1个桶，结果肯定不会在一个桶内，肯定在某两个桶之间
 */
public class _12桶排序_P1 {

    public class Bucket{
        boolean hasNum=false;
        int max;
        int min;
        @Override
        public String toString() {
            return "Bucket{" +
                    "isEmpty=" + hasNum +
                    ", max=" + max +
                    ", min=" + min +
                    '}'+"\n";
        }
    }

    public int findMaxGap(int []arr){
        if(arr == null || arr.length<2){
            return 0;
        }
        //查找数组的最大最小值
        int arrMax=arr[0],arrMin=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arrMax) arrMax=arr[i];
            if(arr[i]<arrMin) arrMin=arr[i];
        }
        //如果最大值和最小值相等，那么返回0
        if(arrMax==arrMin) {
            return 0;
        }

        System.out.println("max ； "+ arrMax  +"  min  "+arrMin);

//        新建桶来容纳 统计 桶中的最大最小值
        ArrayList<Bucket> buckets = new ArrayList<>();
        for(int i=0;i<arr.length+1;i++){
            buckets.add(new Bucket());
        }
        System.out.println(buckets.size());

        //往桶中装入数据，是否包含数据，最大值，最小值
        for ( int i=0;i< arr.length;i++){
            int locate=whichBucket(arr[i],arr.length,arrMin,arrMax);
            buckets.get(locate).max=buckets.get(locate).hasNum? Math.max(buckets.get(locate).max,arr[i]):arr[i];
            buckets.get(locate).min=buckets.get(locate).hasNum? Math.min(buckets.get(locate).min,arr[i]):arr[i];
            buckets.get(locate).hasNum=true;
        }
        System.out.println(buckets);

        int res=0;
        int lastBucket=0;  //上一个非空桶的位置
        for (int i=1;i<buckets.size();i++){
            if(buckets.get(i).hasNum){
                int temp=(buckets.get(i).min-buckets.get(lastBucket).max);
                res=temp>res? temp:res;    //当前桶的最小值  和 上一个非空桶的最大值进行比较
                lastBucket=i;
            }
        }
        System.out.println(res);
        return res;

    }

    public int whichBucket(int num,int len,int min,int max){
        return (int)((num-min)*len/(max-min));
    }

    @Test
    public void test(){
        int[] test = {1,2,5,4,2,3,7,66,55,88,2,66,99,45};
        findMaxGap(test);
    }
}
