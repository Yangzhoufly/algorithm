package 剑指offer;

/**
 * 通过前序和中序重新构建二叉树
 * 通过后序遍历二叉树的到后序遍历的结果
 */
public class _7知道前序中序求后序 {

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

    public static void postOrderRecur(TreeNode head){
        if(head==null){
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.print(head.val+" ");
    }

    public static void main(String[] args) {
        int [] pre={1,2,4,7,3,5,6,8};
        int [] in={4,7,2,1,5,3,8,6};

        postOrderRecur(reConstructBinaryTree(pre,in));
    }

}
