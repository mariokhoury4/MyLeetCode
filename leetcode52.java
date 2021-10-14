import java.util.*;
public class leetcode52 {
    class Solution {
    
        public int res(int n, int temp, int result, Set<Integer> row, Set<Integer> diag1, Set<Integer> diag2){
            if(temp == n){
                result++;
                return result;
            }
            for(int i = 0; i < n; i++){
                if(row.contains(i))continue;
                if(diag1.contains(i + temp))continue;
                if(diag2.contains(temp - i))continue;
                row.add(i);
                diag1.add(i + temp);
                diag2.add(temp - i);
                result = res(n, temp + 1, result, row, diag1, diag2);
                row.remove(i);
                diag1.remove(i + temp);
                diag2.remove(temp - i);
            }
            return result;
            
        }
        
        
        public int totalNQueens(int n) {
            return res(n, 0, 0, new HashSet<>(),new HashSet<>(),new HashSet<>());
        }
    }
}
