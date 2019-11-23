package 牛客初级._06贪心;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * PriorityQueue
 */
public class _03优先级队列PriorityQueue {
    public static void main(String[] args) {

        //默认小顶堆，默认容量为11
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        //添加比较器，实现大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,new Comparator<Integer>(){
            @Override
            public int compare(Integer i1,Integer i2){
                return i2-i1;
            }
        });

        //添加数据
        int []arr={2,3,1,4,2,0,5,7};
        for (int each : arr) {
            minHeap.add(each);
            maxHeap.add(each);
        }

        while(minHeap.size()>0){
            System.out.print(minHeap.poll()+" ");
        }

        System.out.println("\n=====");

        while(maxHeap.size()>0){
            System.out.print(maxHeap.poll()+" ");
        }
    }

}
