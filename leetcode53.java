public class leetcode53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int best = 0;
            int max = 0;
            int min = Integer.MIN_VALUE;
            for(int i = 0; i < nums.length; i++){
                max = Math.max(0, max + nums[i]);
                best = Math.max(best, max);
                min = Math.max(min, nums[i]);
            }
            if(best == 0) return min;
            return best;
        }
    }
}
