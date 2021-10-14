public class leetcode43 {
    class Solution {
    
        public String add(String num1, String num2){
            int nb = 0;
            for(int i = 0; i < num1.length();i++){
                if(num1.charAt(i) - '0' == '0'){
                    nb++;
                }else{
                    break;
                }
            }
            if(nb == num1.length()){
                return num2 + num1;
            }
                
                
            String l = "";
            String s = "";
            if(num1.length() > num2.length()){
                l = num1;
                s = num2;
            }else{
                l = num2;
                s = num1;
            }
            String res = "";
            int buffer = 0;
            int len = s.length();
            for(int i = 0; i < s.length(); i++){
                res = (s.charAt(s.length() - 1 - i) - '0' + l.charAt(l.length() - 1 - i) - '0' + buffer) % 10 + res;
                buffer = (s.charAt(s.length() - 1 - i) - '0' + l.charAt(l.length() - 1 - i) - '0' + buffer) / 10;
            }
            while(l.length() > len){
                res = (l.charAt(l.length() - 1 - len) - '0' + buffer) % 10 + res;
                buffer = (l.charAt(l.length() - 1 - len) - '0' + buffer) / 10;
                len++;
            }
            if (buffer == 1){
                res = "1" + res;
            }
            return res;
        }
          
        public String multiply(String num1, String num2) {
            if(num1.equals("0") || num2.equals("0")) return "0";
            String res = "";
            String buff = "";
            while(num2.length() != 0){
                String temp = num1;
                int mul = num2.charAt(num2.length() - 1) - '0';
                if(mul == 0) temp = "";
                while(mul > 1){
                    temp = add(temp, num1);
                    mul--;
                }
                temp = temp + buff;
                res = add(res, temp);
                if(num2.length() == 1) break;
                num2 = num2.substring(0, num2.length()-1);
                buff = buff + "0";
            }
            return res;
        }
        
    }
}
