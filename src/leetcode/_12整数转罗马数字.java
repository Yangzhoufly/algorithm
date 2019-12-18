package leetcode;

import java.util.HashMap;

public class _12整数转罗马数字 {
    public static String intToRoman (int num) {
        HashMap< Integer,String> map = new HashMap<>();
        map.put(1000,"M");
        map.put(900,"CM");
        map.put(500,"D");
        map.put(400,"CD");
        map.put(100,"C");
        map.put(90,"XC");
        map.put(50,"L");
        map.put(40,"XL");
        map.put(10,"X");
        map.put(9,"IX");
        map.put(5,"V");
        map.put(4,"IV");
        map.put(1,"I");

        int[] devide={1000,900,500,400,100,90,50,40,10,9,5,4,1};

        String res="";

        for(int i=0;i<devide.length;i++){
            int times=(int)(num/devide[i]);
            num=num-times*devide[i];
            while(times>0){
                res+=map.get(devide[i]);
                times--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int num=999;

        System.out.println(intToRoman(999));
    }
}
