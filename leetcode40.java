import java.util.*;
public class leetcode40 {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) { 
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            Arrays.sort(candidates);
            generate(candidates, target, ans, temp, 0);
            return ans;       
        }
        
        private void generate(int[] nums, int target, List<List<Integer>> ans, List<Integer> temp, int index) {  
            if(target == 0){
                ans.add(new ArrayList<>(temp));
                return;
            }
            if(target < 0){
                return;
            }
            if(index == nums.length){
                return;
            }
            // If current index element is part of solution
            temp.add(nums[index]);
            generate(nums, target - nums[index], ans, temp, index+1);
            temp.remove(temp.size() -1); 
            
            // if current index element is not part of the solution
            while(index < nums.length-1 && nums[index] == nums[index+1]){
                index++;
            }
            generate(nums, target, ans, temp, index+1);      
        }
    }
}
