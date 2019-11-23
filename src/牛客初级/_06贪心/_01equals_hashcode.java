package 牛客初级._06贪心;

import java.util.HashSet;
import java.util.Objects;

/**
 *
 *
 * Set集合存储元素不重复的原理：
 *        根据对象的hashCode和equals方法来决定如何存储；
 *
 * 	如果我们往集合中存放自定义的对象，那么保证其唯一；
 * 	就必须重写hashCode和equals方法建立属于当前对象的比较方式。
 * 	1、计算哈希值，放入对应哈希值的链中
 *  2、根据equals方法判断，链中是否有相同的元素。
 */

public class _01equals_hashcode {
    public static class Book{
        public String name;
        public int price;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Book book = (Book) o;
            return price == book.price &&
                    Objects.equals(name, book.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price);
        }

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

    }

    public static void main(String[] args) {
        Book a = new Book("a", 1);
        Book b = new Book("b", 2);
        Book c = new Book("b", 2);
        Book d = new Book("b", 2);

        HashSet<Book> books = new HashSet<>();
        books.add(a);
        books.add(a);
        books.add(b);
        books.add(c);
        books.add(d);
        System.out.println(books);


    }


}
