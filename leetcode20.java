import java.util.*;
public class leetcode20 {
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
    }
}
