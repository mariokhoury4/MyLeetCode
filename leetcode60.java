import java.util.*;
public class leetcode60 {
    class Solution {
        public int factorial(int n){
            int res = 1;
            for (int i = 2; i < n; i++){
                res = res * i;
            }
            return res;
        }
    
        public String getPermutation(int n, int k) {
            
            List<Integer> digits = new ArrayList<>();
            for(int i = 0; i < n; i++){
                digits.add(i+1);
            }
            
            
            String result = "";
            while(digits.size() != 0){
                int curr = factorial(n);
                int index = k/curr;
                if(k%curr == 0){
                    index = index - 1;
                }
                result = result + Integer.toString(digits.get(index));
                digits.remove(index);
                k = k -curr*index;
                n = n - 1;
            }
            return result;
        
        
        }
    }
}
