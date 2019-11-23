package 牛客初级._06贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 *但是在设计类的时候，可能没有考虑到让类实现Comparable接口，那么就需要用到另外的一个比较器接口Comparator。
 *
 *从上面的实例我们可以发现，compareTo(T o)只有一个参数，而Comparator接口中必须要实现的compare(T o1,T o2)就有两个参数。
 *
 *  Arrays.sort(pens,new PenComparator());，调用Arrays.sort进行排序 时 传入比较器
 */

public class _01比较器Comparator {

    public static class Pen{
        public String name;
        public int price;

        public Pen(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Pen{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }


    public static class PenComparator implements Comparator<Pen> {
        @Override
        public int compare(Pen o1, Pen o2) {
            if(o1.price > o2.price){
                return 1;
            }else if(o1.price < o2.price){
                return -1;
            }else{
                return 0;
            }
        }
    }

    public static void main(String[] args) {

        Pen a = new Pen("a", 3);
        Pen b = new Pen("b", 4);
        Pen c = new Pen("c", 4);
        Pen d = new Pen("d", 6);
        Pen e = new Pen("e", 1);
        Pen [] pens={a,b,c,d,e};
        Arrays.sort(pens,new PenComparator());
        for (Pen pen : pens) {
            System.out.println(pen);
        }
    }
}
