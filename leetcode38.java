public class leetcode38 {
    class Solution {
        public String countAndSay(int n) {
            if(n == 1) return "1";
            String s = "1";
            int counterr = 1;
            while(counterr != n){
                String temp = "";
                int counter = 1;
                for(int i = 0; i < s.length() - 1; i++){
                    if(s.charAt(i) == s.charAt(i + 1)){
                        counter = counter + 1;
                    }else{
                        temp = temp + String.valueOf(counter) + s.charAt(i);
                        counter = 1;
                    }
                }
                temp = temp + String.valueOf(counter) + s.charAt(s.length()- 1);
                counterr++;
                s = temp;
            }
            return s;
            
        }
    }
}
