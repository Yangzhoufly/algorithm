package 牛客初级._02其他;

import org.junit.Test;

/**
 * 队列：先进先出
 * 使用有限数组来构造队列结构，实现元素进入队列，元素出队列，打印当前队列
 *
 */
public class _13数组构造队列结构 {
    public class ArrayQueue{
        public int [] arr;
        public int size;  //来标记当前队列长度，超过既定长度，不在进入，没有元素不再出
        public int length;

        int last=0;  //最新进来的元素应该在的位置
        int first=0;  //下一个弹出的元素在的位置

        public ArrayQueue(int length){
            if(length<2){
                throw new IllegalArgumentException("队列长度太小，初始化错误");
            }
            this.arr=new int [length];
            this.size=0;
            this.length=length;
        }

        public void  input(int num){
            if(size<length){
                arr[last]=num;
                size++;
                last=(last+1)%length;
            }else{
                System.out.println("超过队列长度了，没有录入："+num);
            }
        }

        public void output(){
            if(size>0){
                System.out.println("队列输出元素："+arr[first]);
                size--;
                first=(first+1)%length;
            }else{
                System.out.println("队列已经没有元素了！！！");
            }
        }

        public void printQueue(){
            System.out.print("队列是：");
            if(first<last){
                for(int i=first;i<last;i++){
                    System.out.print(arr[i]+" ");
                }
            }else if(first==last){
                if(size==length){
                    for(int i=first;i<length;i++){
                        System.out.print(arr[i]+" ");
                    }
                    for(int i=0;i<last;i++){
                        System.out.print(arr[i]+" ");
                    }
                }else{
                    System.out.print("队列为空！");
                }
            }else{
                for(int i=first;i<length;i++){
                    System.out.print(arr[i]+" ");
                }
                for(int i=0;i<last;i++){
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
        }

    }


    @Test
    public void test(){
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.input(1);
        arrayQueue.printQueue();
        arrayQueue.input(2);
        arrayQueue.printQueue();
        arrayQueue.input(3);
        arrayQueue.printQueue();
        arrayQueue.input(4);
        arrayQueue.printQueue();
        arrayQueue.input(5);
        arrayQueue.printQueue();
        arrayQueue.input(6);
        arrayQueue.printQueue();
        arrayQueue.output();
        arrayQueue.printQueue();
        arrayQueue.output();
        arrayQueue.printQueue();
        arrayQueue.output();
        arrayQueue.printQueue();
        arrayQueue.output();
        arrayQueue.printQueue();
        arrayQueue.output();
        arrayQueue.printQueue();
        arrayQueue.input(6);
        arrayQueue.printQueue();
        arrayQueue.output();
        arrayQueue.printQueue();


    }

}
