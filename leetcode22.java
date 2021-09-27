import java.util.*;
public class leetcode22 {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> q = new Stack<>();
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '(') q.add('(');
                else if(s.charAt(i) == '[') q.add('[');
                else if(s.charAt(i) == '{') q.add('{');
                else if(s.charAt(i) == ')'){
                    if(q.isEmpty() || q.pop() != '(') return false;
                }else if(s.charAt(i) == ']'){
                    if(q.isEmpty() || q.pop() != '[') return false;
                }else if(s.charAt(i) == '}'){
                    if(q.isEmpty() || q.pop() != '{')return false;
                }
            }
            if(q.size() != 0) return false;
            return true;
        }
    
        public List<String> recursive(int n, List<String> res, String temp){
            if(temp.length() == n * 2){
                if(isValid(temp)){
                    res.add(temp);
                }
            }else{
                temp = temp + "(";
                recursive(n, res, temp);
                temp = temp.substring(0, temp.length() - 1);
                temp = temp + ")";
                recursive(n, res, temp);
            }
            return res;
            
        }
    
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            return recursive(n,result, "");
        }
    }
}
