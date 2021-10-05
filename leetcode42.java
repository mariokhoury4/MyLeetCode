public class leetcode42 {
    class Solution {
        public int trap(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int result = 0;
            int max_left = 0;
            int max_right = 0;
            while(left < right){
                if(height[left] < height[right]){
                    if(height[left] >= max_left){
                        max_left = height[left];
                    }else{
                        result = result + (max_left - height[left]);
                    }
                    left++;
                }else{
                    if(height[right] >= max_right){
                        max_right= height[right];
                    }else{
                        result = result + (max_right - height[right]);
                    }
                    right--;
                }
            }
            return result;
        }
    }
}
