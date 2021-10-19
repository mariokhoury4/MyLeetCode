public class leetcode55 {
    class Solution {
        public boolean canJump(int[] nums) {
            if(nums.length == 1) return true;
            return rec(nums, 0, nums[0]);
        }
        
        public boolean rec(int[] nums, int nb, int curr){
            if(nb == nums.length - 1) return true;
            
            int maxJump = Math.max(curr, nums[nb]);
            if (maxJump == 0) {
                return false; 
            }
            return rec(nums, nb + 1, maxJump - 1);
        }
    }
    
}
