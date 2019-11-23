package 牛客初级._04树;

/**
 * 内存到字符串
 * 通过先序遍历进行序列化
 * 加上下划线是为了区分每一个节点上的值
 * 子节点为null用#表示
 */
public class _05二叉树前序序列化 {
    public static class Node{
        public int  value;
        public Node left=null;
        public Node right=null;

        public Node(int value) {
            this.value = value;
        }
    }

    public static String serializeBinary(Node head){
        if(head== null){
            return "#_";
        }
        String res=head.value+"_";
        res+=serializeBinary(head.left);
        res+=serializeBinary(head.right);
        return res;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(serializeBinary(head));

    }

}
