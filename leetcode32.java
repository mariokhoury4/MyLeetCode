import java.util.*;
public class leetcode32 {
    class Solution {
        public int longestValidParentheses(String s) {
            int result = 0;
            Stack<Integer> stack = new Stack<>();
            int j = 0;
            for(int i = 0; i < s.length();){
                if(s.charAt(i) == '(') {
                    stack.add(1);
                    i++;
                }else if(s.charAt(i) == ')'){
                    if(stack.size() == 1){
                        stack.pop();
                        result = Math.max(result, i - j + 1);
                        i++;
                    }else if(stack.size() > 1){
                        stack.pop();
                        i++;
                    }else{
                        stack = new Stack<>();
                        i++;
                        j = i;
                    }
                }
                if(i == s.length()){
                    if(stack.size() != 0){
                        i = j + 1;
                        j = i;
                        stack = new Stack<>();
                    }
                }   
            }
            return result;
        }
    }
}
