package 牛客初级._07递归动态规划;
//运行超时
public class _08_01背包问题_递归 {
    public static void main(String[] args) {
        int[]volume={3,2,4};
        int[]value={5,4,2};
        int bagVo=8;
        //System.out.println(bag(volume, value, bagVo, 0, 0, 0));
        int res=bag3(volume, value, bagVo, 0, 0);
        System.out.println(res);
    }


    //最后版本
    private static int bag3(int[] volume, int[] value,int bagVo,int index,int sumVo) {
        if(index==volume.length){
            return 0;
        }
        int choose= sumVo+volume[index]<=bagVo?  bag3(volume,value,bagVo,index+1,sumVo+volume[index])+value[index]  : 0;
        int notChoose=bag3(volume,value,bagVo,index+1,sumVo);
        return Math.max(choose,notChoose);
    }

    //自己写的
    private static int bag(int[] volume, int[] value,int bagVo,int index,int sumVo,int sumVa) {
        if(sumVo>bagVo){
            return 0;
        }
        if(index==volume.length){
            return sumVa;
        }
        int choose=bag(volume,value,bagVo,index+1,sumVo+volume[index],sumVa+value[index]);
        int notChoose=bag(volume,value,bagVo,index+1,sumVo,sumVa);
        return Math.max(choose,notChoose);
    }

    //左神
    private static int bag2(int[] volume, int[] value,int bagVo,int index,int sumVo) {
        if(index==volume.length){
            return 0;
        }
        if(sumVo+volume[index]>bagVo){
            return 0;
        }
        int choose=bag2(volume,value,bagVo,index+1,sumVo+volume[index])+value[index];
        int notChoose=bag2(volume,value,bagVo,index+1,sumVo);
        return Math.max(choose,notChoose);
    }



}


