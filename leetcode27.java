public class leetcode27 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int j = nums.length - 1;
            for(int i = nums.length - 1; i >= 0; i--){
                if (nums[i] == val){
                    nums[i] = nums[j];
                    nums[j] = val;
                    j--;
                }
            }
            return j + 1;
        }
    }
}
