import java.util.*;
public class leetcode47 {
    class Solution {
        Set<List<Integer>> set;
        public void rec(List<Integer> temp, int[] nums, int[] t){
            if(temp.size() == nums.length){
                if(!set.contains(temp)){
                    set.add(new ArrayList<>(temp));
                }
                return;
            }
            for(int i = 0; i < nums.length; i++){
                if(t[i] == 1){
                    continue;
                }
                t[i] = 1;
                temp.add(nums[i]);
                rec(temp, nums,  Arrays.copyOf(t, t.length));
                t[i] = 0;
                temp.remove(temp.size() - 1);
            }
        }
        public List<List<Integer>> permuteUnique(int[] nums) {
            set = new HashSet<>();
            int[] t = new int[nums.length];
            for(int i = 0; i < nums.length; i++){
                t[i] = 0;
            }
            rec(new ArrayList<>(), nums, t);
            return new ArrayList<>(set);
        }
    }
}
