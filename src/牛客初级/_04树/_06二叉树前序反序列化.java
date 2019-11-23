package 牛客初级._04树;

import java.util.LinkedList;
import java.util.Queue;
import  牛客初级._04树._05二叉树前序序列化.Node;
import static 牛客初级._04树._05二叉树前序序列化.serializeBinary;

/**
 * 反序列化，从string ->二叉树
 *根据05的结果，进行反序列化，前遍历
 *
 */

public class _06二叉树前序反序列化 {

    public static Node deserializeBinary(String tree){
        if(tree==null || tree.length()==0){
            return null;
        }
        String[] node = tree.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String s : node) {
            queue.offer(s);
        }
        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue ) {
        if(queue==null || queue.size()==0){
            return null;
        }
        String value = queue.poll();
        if(value.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left=reconPreOrder(queue);
        head.right=reconPreOrder(queue);
        return head;
    }

    public static void main(String[] args) {
        String tree="1_2_4_#_#_#_3_6_#_#_7_#_#_";
        //deserializeBinary(tree);

        System.out.println(serializeBinary(deserializeBinary(tree)));
    }
}
