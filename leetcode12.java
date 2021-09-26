import java.util.*;
public class leetcode12 {
    class Solution {
        public String intToRoman(int num) {
            Map<Integer, String> mp = new HashMap<>();
            mp.put(1,"I");
            mp.put(4,"IV");
            mp.put(5,"V");
            mp.put(9,"IX");
            mp.put(10,"X");
            mp.put(40,"XL");
            mp.put(50,"L");
            mp.put(90,"XC");
            mp.put(100,"C");
            mp.put(400,"CD");
            mp.put(500,"D");
            mp.put(900,"CM");
            mp.put(1000,"M");
            
            int[] l = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
            
            String res = "";
            int counter = 0;
            while(num != 0){
                int temp = num / l[counter];
                if (temp == 0){
                    counter = counter + 1;
                }else{
                    num = num - l[counter];
                    res = res + mp.get(l[counter]);
                }
            }
        return res;
            
        }
    }
}
