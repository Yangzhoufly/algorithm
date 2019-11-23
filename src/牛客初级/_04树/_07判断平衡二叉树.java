package 牛客初级._04树;

import java.util.Map;

/**
 * 平衡二叉树（Balanced Binary Tree）具有以下性质：
 * 它是一棵空树 或 它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 * 它或者是一棵空树
 * 或者->任何一个节点，它的左子树都比它小，右子树都比它大
 * 二叉树中序的遍历是升序的，那么是搜索二叉树
 * 搜索二叉树通常不包含重复节点，可以压缩
 */

public class _07判断平衡二叉树 {

    public static class ResInfo{
        boolean isBBT;
        int height;
        public ResInfo(boolean isBBT, int height) {
            this.isBBT = isBBT;
            this.height = height;
        }
    }

    public static boolean isBBT(Node head){
        if(head==null ){
            return true;
        }
        ResInfo resInfo = process(head);
        System.out.println(resInfo.isBBT+" "+resInfo.height);
        return  resInfo.isBBT;
    }

    public static ResInfo process(Node head){
        //如果为空，那么是平衡的
        if(head==null ){
            return new ResInfo(true,0);
        }

        ResInfo resLeft = process(head.left);
        if(resLeft.isBBT==false){
            return new ResInfo(false,0);
        }

        ResInfo resRight = process(head.right);
        if(resRight.isBBT==false){
            return new ResInfo(false,0);
        }

        if(Math.abs(resLeft.height-resRight.height)>1){
            return new ResInfo(false ,0);
        }else{
            return new ResInfo(true,Math.max(resLeft.height,resRight.height)+1);
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        isBBT(head);
    }

}
