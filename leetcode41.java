public class leetcode41 {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            int i = 0;
            int result = 1;
            while(i < n){
                int j = nums[i] - 1;
                if(j >= n || j < 0 || nums[j] == nums[i]) i++;
                else swap(nums, i, j);
            }
            for(int j = 0; j < n; j++){
                if(nums[j] == result) result++;
                else if (j + 1 >= result) return result;
            }
            return result;
        }
        public void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
