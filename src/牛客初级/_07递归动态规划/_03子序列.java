package 牛客初级._07递归动态规划;

/**
 * 一个串的“子序列”(subsequence)是将这个串中的一些字符提取出来得到一个新串，并且不改变它们的相对位置关系。
 * yangzhoufly
 * yzfly,fly,yz....都是子序列
 *
 * 就是判断一个char要还是不要，递归
 */
public class _03子序列 {

    public static void printSubseq(String str ,int index,String res){
        if(index==str.length()){
            System.out.println(res);
            return;
        }
        printSubseq(str,index+1,res);
        printSubseq(str,index+1,res+str.charAt(index));
    }

    public static void main(String[] args) {
        String test="abc";
        printSubseq(test,0,"");

    }
}
