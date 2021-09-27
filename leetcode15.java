import java.util.*;

public class leetcode15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> result = new HashSet<>();
            for(int i = 0; i < nums.length; i++){
                Set<Integer> set = new HashSet<>();
                for(int j = 0; j < nums.length; j++){
                    if(i == j){
                        continue;
                    }
                    if(set.contains(-nums[i] - nums[j])){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(-nums[i] - nums[j]);
                        Collections.sort(temp);
                        result.add(temp);
                    }
                    set.add(nums[j]);
                }
            }
            List<List<Integer>> targetList = new ArrayList<>(result);
            return targetList;
            
        }
    }
}
