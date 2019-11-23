package 牛客初级._04树;

import java.util.Stack;

import static 牛客初级._04树._03打印二叉树.printTree;

/**
 * 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）  ->BST
 *
 * 根据中序遍历来进行，如果是搜索二叉树，那么它的中序遍历是升序的
 *
 * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 *
 * inOrderUnRecur 中序遍历 改造
 *
 */

public class _08判断搜索二叉树 {


    public static boolean isBST(Node head){
        if(head==null){
            return true;
        }
        int pre=Integer.MIN_VALUE;

        Stack<Node> stack = new Stack<>();
        while(head!=null || !stack.isEmpty()){
            while(head!=null){
                stack.push(head);
                head=head.left;
            }
            while(!stack.isEmpty()){
                head=stack.pop();

                ////////////////////
                if(head.value<=pre){
                    return false;
                }
                pre=head.value;
                ///////////////

                //弹出 打印
                System.out.print(head.value+" ");
                head=head.right;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.left = new Node(2);
        head.right = new Node(5);
        head.left.left = new Node(1);
        head.right.left = new Node(4);
        head.right.right = new Node(6);

        System.out.println(isBST(head));


        //printTree(head);
    }
}
