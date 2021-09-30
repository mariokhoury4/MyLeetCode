public class leetcode35 {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int i = 0;
            int j = nums.length - 1;
            int mid = 0;
            while(i <= j){
                mid = (i + j) / 2;
                if(target == nums[mid]){
                    while(mid >= 0 && nums[mid] == target){
                        mid--;
                    }
                    return mid + 1;
                }else if(target < nums[mid]){
                    j = mid - 1;
                }else{
                    i = mid + 1;
                }
            }
            if(nums[mid] < target) return mid + 1;
            return mid;
        }
    }
}
