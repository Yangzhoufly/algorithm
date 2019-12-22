package 剑指offer;


/**

 */
public class _8二叉树的下一个节点newcode {
    public static class TreeLinkNode {
        char val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
    }

    public static  TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null){
            return null;
        }
        TreeLinkNode res=null;
        if(pNode.right!=null){
            TreeLinkNode temp=pNode.right;
            while(temp.left!=null){
                temp=temp.left;
            }
            return temp;
        }else{
            TreeLinkNode temp=pNode;
            while(temp.next!=null){
                if(temp==temp.next.left){
                    return temp.next;
                }
                temp=temp.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }


}
