package 牛客初级._02其他;

import org.junit.Test;

import java.util.Stack;

/**
 * 实现一个特殊的栈,在实现栈的基本功能的基础上,再实现返
 * 回栈中最小元素的操作。
 * 【要求】
 * 1.pop、push、getMin操作的时间复杂度都是O(1)。
 * 2.设计的栈类型可以使用现成的栈结构。
 *
 * 思路：建立一个data栈，同时建立一个min栈，min栈栈顶与data同时入出，min栈顶保持当前最小的值
 *使用系统提供的栈结构 Stack
 */
public class _14栈_P1 {
    public class MyStack{
        public Stack<Integer> dataStack;
        public Stack<Integer> minStack;

        public MyStack() {
            this.dataStack = new Stack<Integer> ();
            this.minStack = new Stack<Integer> ();
        }

        public void push(Integer num){
            if(dataStack.empty()){
                dataStack.push(num);
                minStack.push(num);
            }else{
                dataStack.push(num);
                Integer next=num<minStack.peek()? num:minStack.peek();
                minStack.push(next);
            }
        }

        public void pop(){
            dataStack.pop();
            minStack.pop();
        }

        public Integer getMin(){
            if(minStack.empty()){
                System.out.println("队列为空");
            }
            return minStack.peek();
        }

        @Override
        public String toString() {
            return "MyStack{" +
                    "dataStack=" + dataStack +
                    ", minStack=" + minStack +
                    '}';
        }
    }

    @Test
    public void test(){
        MyStack MyStack = new MyStack();
        MyStack.push(5);
        MyStack.push(6);
        MyStack.push(2);
        MyStack.push(4);
        MyStack.push(9);
        MyStack.push(7);
        System.out.println(MyStack);
        System.out.println(MyStack.getMin());
    }

    @Test
    public void test1(){
        Stack<Integer> stack=new Stack<>();
        stack.push(5);
        stack.push(6);
        System.out.println(stack);
    }



}
