package 牛客初级._04树;
/**
 * 要求时间复杂度小于  o(n)
 *
 * 满二叉树  节点个数  (2^n-1)
 *
 * num << 1,相当于num乘以2
 * num >> 1,相当于num除以2
 * 1<<3   2的3次方
 */
public class _10完全二叉树节点个数 {

    private static int nodeNum(Node head) {
        if(head==null){
            return 0;
        }

        int num=1;//节点本身算1
        int levelParent=leftLevels(head);
        int levelRight=leftLevels(head.right);

        //左子树是满的,计算左子树（满树）节点 + 统计右边  + 1
        if(levelParent==levelRight+1 ){
            num+=(1<<levelRight)-1 + nodeNum(head.right);
        }

        //右子树是满的，计算右子树（满树）节点 + 统计左边 +1
        if(levelParent==levelRight+2 ){
            num+=nodeNum(head.left)+(1<<levelRight)-1;
        }

        return num;
    }

    //返回从当前节点到最左的层数
    private static int leftLevels(Node head){
        int level=0;
        while(head!=null){
            level++;
            head=head.left;
        }
        return level;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));
    }
}
