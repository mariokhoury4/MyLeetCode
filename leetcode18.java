import java.util.*;

public class leetcode18 {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Set<List<Integer>> res = new HashSet<>();
            Arrays.sort(nums);
            for(int i = 0; i < nums.length - 1; i++){
                for(int j = i + 1; j < nums.length; j++){
                    int min = 0;
                    int max = nums.length - 1;
                    while(min < max){
                        if(i == min || j == min){
                            min = min + 1;
                            continue;
                        }
                        if(i == max || j == max){
                            max = max - 1;
                            continue;
                        }
                        int temp = nums[i] + nums[j] + nums[min] + nums[max];
                        if(temp < target){
                            min = min + 1;
                        }else if(temp > target){
                            max = max - 1;
                        }else if (temp == target){
                            List<Integer> t = new ArrayList<>();
                            t.add(nums[i]);
                            t.add(nums[j]);
                            t.add(nums[min]);
                            t.add(nums[max]);
                            Collections.sort(t);
                            if(!res.contains(t)){    
                                res.add(t);
                            }
                            min = min + 1;
                            max = max - 1;
                        }
                    }
                }
            }
            result.addAll(res);
            return result;
            
        }
    }
}
