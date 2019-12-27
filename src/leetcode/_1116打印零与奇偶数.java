package leetcode;

import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private boolean printZero=true;
    private boolean printOne=false;
    private boolean printTwo=false;
    private int count=0;


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public  void zero(IntConsumer printNumber) throws InterruptedException {
        synchronized (ZeroEvenOdd.class){
            while(count<n) {
                if (printZero) {
                    printNumber.accept(0);
                    if (count % 2 == 0) {
                        printOne = true;
                        printZero = false;
                        printTwo = false;
                    } else {
                        printOne = false;
                        printZero = false;
                        printTwo = true;
                    }
                    ZeroEvenOdd.class.notify();
                }
                ZeroEvenOdd.class.wait();
            }
        }
    }

    public  void even(IntConsumer printNumber) throws InterruptedException {
        synchronized (ZeroEvenOdd.class){
            while(count<n) {
                if (printOne) {
                    printNumber.accept(1);

                    printOne = false;
                    printZero = false;
                    printTwo = true;

                    ZeroEvenOdd.class.notify();
                }
                ZeroEvenOdd.class.wait();
            }
        }

    }

    public  void odd(IntConsumer printNumber) throws InterruptedException {
        synchronized (ZeroEvenOdd.class){
            while(count<n) {
                if (printTwo) {
                    printNumber.accept(1);
                    count++;
                    printOne = false;
                    printZero = true;
                    printTwo = false;
                    ZeroEvenOdd.class.notify();
                }
                ZeroEvenOdd.class.wait();
            }
        }

    }
}

class MyThread extends Thread{
    ZeroEvenOdd obj=new ZeroEvenOdd(3);

    @Override
    public void run() {
        obj.even();

    }
}

public class _1116打印零与奇偶数 {


}
