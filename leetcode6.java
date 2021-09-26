import java.util.*;


public class leetcode6 {
    class Solution {
        public String convert(String s, int numRows) {
            if(numRows == 1) return s;
            boolean monte = true;
            int counter = 0;
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < numRows; i++){
                temp.add("");
            }
            for(int i = 0; i < s.length(); i++){
                if(monte == true){
                    if(counter == numRows - 1){
                        monte = false;
                        temp.set(counter,temp.get(counter) + s.charAt(i));
                        counter = counter - 1;
                    }else{
                        temp.set(counter,temp.get(counter) + s.charAt(i));
                        counter = counter + 1;
                    }
                }else{
                    if(counter == 0){
                        monte = true;
                        temp.set(counter,temp.get(counter) + s.charAt(i));
                        counter = counter + 1;
                    }else{
                        temp.set(counter,temp.get(counter) + s.charAt(i));
                        counter = counter - 1;
                    }
                }
            }
            String res = "";
            for(int i = 0; i < temp.size(); i++){
                res = res + temp.get(i);
            }
            return res;
        }
    }
}
