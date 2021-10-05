import java.util.*;
public class leetcode39 {
    class Solution {
        List<List<Integer>> combinations;
        public void recursive(int index, int[] candidates, int target, List<Integer> temp){
            if(target == 0){
                combinations.add(new ArrayList<>(temp));
                return ;
            }
            if(target < 0 || index >= candidates.length)return ;
            for(int i = index; i < candidates.length; i++){
                temp.add(candidates[i]);
                recursive(i, candidates, target - candidates[i], temp);
                temp.remove(temp.size() - 1);
            }
            return ;
        }
        
        
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            combinations = new ArrayList<>();
            recursive(0, candidates, target, new ArrayList<>());
            return combinations;
        }
    }
}
