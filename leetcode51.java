import java.util.*;

public class leetcode51{
    class Solution {
        List<List<String>> result;
        
        public void rec(List<String> temp, int n, Set<Integer> row, Set<Integer> col, Set<Integer> diag1, Set<Integer> diag2){
            if(temp.size() == n){
                result.add(new ArrayList<>(temp));
                return;
            }
            for(int i = 0; i < n; i++){
                if(col.contains(i)){
                    continue;
                }
                if(diag1.contains(i + temp.size())){
                    continue;
                }
                if(diag2.contains(temp.size() - i)){
                    continue;
                }
                diag2.add(temp.size() - i);
                diag1.add(i + temp.size());
                col.add(i);
                
                String t = "";
                for(int j = 0; j < n; j++){
                    if(i == j){
                        t = t + "Q";
                    }else{
                        t = t + ".";
                    }
                }
                temp.add(t);
                rec(temp, n, row, col, diag1, diag2);
                temp.remove(temp.size() - 1);
                diag2.remove(temp.size() - i);
                diag1.remove(i + temp.size());
                col.remove(i);
                
            }
        }
        
        
        public List<List<String>> solveNQueens(int n) {
            result = new ArrayList<>();
            rec(new ArrayList<>(), n, new HashSet<>(),new HashSet<>(),new HashSet<>(),new HashSet<>());
            return result;
        }
    }
}