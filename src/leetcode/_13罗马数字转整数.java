package leetcode;




public class _13罗马数字转整数 {
    public static int romanToInt(String s) {
        int res=0;
        if(s.length()==0){
            return 0;
        }
        while(s.length()>0){
            if(s.startsWith("CM")){
                res+=900;
                s=s.replaceFirst("CM","");
            }else if(s.startsWith("CD")){
                res+=400;
                s=s.replaceFirst("CD","");
            }else if(s.startsWith("XC")){
                res+=90;
                s=s.replaceFirst("XC","");
            }else if(s.startsWith("XL")){
                res+=40;
                s=s.replaceFirst("XL","");
            }else if(s.startsWith("IX")){
                res+=9;
                s=s.replaceFirst("IX","");
            }else if(s.startsWith("IV")){
                res+=4;
                s=s.replaceFirst("IV","");
            }else if(s.startsWith("M")){
                res+=1000;
                s=s.replaceFirst("M","");
            }else if(s.startsWith("D")){
                res+=500;
                s=s.replaceFirst("D","");
            }else if(s.startsWith("C")){
                res+=100;
                s=s.replaceFirst("C","");
            }else if(s.startsWith("L")){
                res+=50;
                s=s.replaceFirst("L","");
            }else if(s.startsWith("X")){
                res+=10;
                s=s.replaceFirst("X","");
            }else if(s.startsWith("V")){
                res+=5;
                s=s.replaceFirst("V","");
            }else if(s.startsWith("I")){
                res+=1;
                s=s.replaceFirst("I","");
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String in="MCMXCIV";
        System.out.println(romanToInt(in));
    }
}
