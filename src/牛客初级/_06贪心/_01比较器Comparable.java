package 牛客初级._06贪心;

import java.util.Arrays;


/**
 * 让需要进行排序的对象实现Comparable接口，重写其中的compareTo(T o)方法，
 * 在其中定义排序规则，那么就可以直接调用java.util.Arrays.sort()来排序对象数组，
 */

public class _01比较器Comparable {
    public static class Book implements Comparable<Book>{

        public String name;
        public int price;

        public Book(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "book{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
        @Override
        public int compareTo(Book o) {
            if(this.price>o.price){
                return 1;
            }else if(this.price<o.price){
                return -1;
            }else{
                return 0;
            }
        }
    }




    public static void main(String[] args) {
        Book a = new Book("a", 1);
        Book b = new Book("b", 2);
        Book [] books={a,b};
        System.out.println(a.compareTo(b));

        Arrays.sort(books);
        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println("===========");


    }
}
