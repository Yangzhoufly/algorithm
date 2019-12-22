package 剑指offer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 1、通过先序遍历确定根节点
 * 2、通过中序遍历确定左子树有哪些，右子树有哪些
 * 递归
 */
public class _7重建二叉树 {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
       return  reConstruct(pre,0,pre.length-1,in,0,in.length-1);
    }

    public  static TreeNode reConstruct(int [] pre,int preStart,int preEnd,int [] in,int inStart,int inEnd) {

        if (preStart == preEnd && inStart == inEnd) {
            return new TreeNode(pre[preStart]);
        }

        //前序遍历的第一个是root
        int root = pre[preStart];
        TreeNode head = new TreeNode(root);

        //在中序中找到前序的头节点
        int preHeadInindex = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root) {
                preHeadInindex = i;
                break;
            }
        }
        //preHeadInindex  左边的是root的左子树  右边的是root的右子树
        int leftTreeLen = preHeadInindex - inStart;
        int rightTreeLen = inEnd - preHeadInindex;
        head.left = leftTreeLen == 0 ? null : reConstruct(pre, preStart + 1, preStart + leftTreeLen, in, inStart, preHeadInindex - 1);
        head.right = rightTreeLen == 0 ? null : reConstruct(pre, preStart + leftTreeLen + 1, preEnd, in, preHeadInindex + 1, inEnd);
        return head;

    }

    public static void main(String[] args) {
        int [] pre={1,2,4,7,3,5,6,8};
        int [] in={4,7,2,1,5,3,8,6};
        reConstructBinaryTree(pre,in);
    }

}
