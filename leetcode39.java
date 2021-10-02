import java.util.*;
public class leetcode39 {
    class Solution {
        public Set<List<Integer>> recursive(int[] candidates, int target, int curr, Set<List<Integer>> result, List<Integer> temp){
            
            if(curr == target){
                List<Integer> t1 = new ArrayList<>();
                for(int i = 0; i < temp.size();i++){
                    t1.add(temp.get(i));
                }
                Collections.sort(t1);
                result.add(t1);
            }
            for(int i = 0; i < candidates.length; i++){
                if(candidates[i] + curr > target){
                    break;
                }
                temp.add(candidates[i]);
                recursive(candidates, target, curr + candidates[i], result, temp);
                temp.remove(new Integer(candidates[i]));
            }
            return result;
        }
        
        
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            Set<List<Integer>> result = new HashSet<>();
            List<Integer> temp = new ArrayList<>();
            List<List<Integer>> res =  new ArrayList<>(recursive(candidates, target, 0,result, temp));
            return res;
        }
    }
}
