package 剑指offer;


/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 *
 * 1、该节点有右子树： 那么它的下一个节点就是右子树中最左的节点
 * 2、该节点无右子树：
 *          2.1：它是它父节点的左孩子，那么它的下一个节点就是它的父节点
 *          2.2：它是它父节点的右孩子，就要递归向上，找到一个节点是它父节点的左孩子的这样一个节点，那么这个节点的父节点就是原始节点的下一个节点
 */
public class _8二叉树的下一个节点 {
    public static class Node{
        char val;
        Node left;
        Node right;
        Node parent;
        Node midnNext;

        public Node(char val) {
            this.val = val;
        }
    }

    //得到一个节点的下一个中序遍历节点
    public static Node getNext(Node head){
        if(head==null){
            return null;
        }
        Node res=null;
        if(head.right!=null){
            Node temp=head.right;
            while(temp.left!=null){
                temp=temp.left;
            }
            res=temp;
        }else{
            Node temp=head;
            while(temp.parent!=null){
                if(temp==temp.parent.left){
                    res=temp.parent;
                    break;
                }
                temp=temp.parent;
            }
        }
        return res;
    }

//将整个数构建成含有中序遍历next的结构
    public static void addNext(Node head){
        if(head==null){
            return ;
        }
        head.midnNext=getNext(head);
        addNext(head.left);
        addNext(head.right);
    }


    public static void main(String[] args) {
        Node head=new Node('a');
        head.left=new Node('b');
        head.left.left=new Node('d');

        head.left.right=new Node('e');
        head.left.right.left=new Node('h');
        head.left.right.right=new Node('i');

        head.parent=null;
        head.left.parent=head;
        head.left.left.parent=head.left;
        head.left.right.parent=head.left;
        head.left.right.left.parent=head.left.right;
        head.left.right.right.parent=head.left.right;


        head.right=new Node('c');
        head.right.left=new Node('f');
        head.right.right=new Node('g');

        head.right.parent=head;
        head.right.left.parent=head.right;
        head.right.right.parent=head.right;


        addNext(head);
        //整棵树最左边的节点
        Node temp=head.left.left;

        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.midnNext;
        }


    }

}
