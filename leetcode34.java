public class leetcode34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int i = 0;
            int j = nums.length - 1;
            
            int[] res = new int[2];
            while(i <= j){
                int mid = (i + j)/2;
                if(nums[mid] == target){
                    while(nums[i] != target){
                        i++;
                    }
                    while(nums[j] != target){
                        j--;
                    }
                    res[0] = i;
                    res[1] = j;
                    return res;
                }else if(nums[mid] > target){
                    j = mid - 1;
                }else{
                    i = mid + 1;
                }
            }
            res[0] = -1;
            res[1] = -1;
            return res;
            
            
        }
    }
}
