package 牛客初级._07递归动态规划;

public class _02汉诺塔 {

    //把顶上的n-1个移动到中间  +  把最下边的移到最右边   + 把n-1个移到最右边

    public static long hanoi(long n){
        if(n==1){
            return 1;
        }
        return  hanoi(n-1)+1+hanoi(n-1);
    }

    //把第n个盘从from,借助help，移动到to
    public static void process(int n,String from,String help,String to){
        if(n==1){
            //只有一个，直接放到右
            System.out.println("move "+n+" from "+from+" to "+to);
        }else{
            //有多个，先把n-1放到help
            process(n-1,from,to,help);
            //再把n放到to
            System.out.println("move "+n+" from "+from+" to "+to);
            //再把n-1放到to
            process(n-1,help,from,to);
        }
    }

    public static void main(String[] args) {
        System.out.println(hanoi(3));
        process(3,"左","中","右");
    }
}
