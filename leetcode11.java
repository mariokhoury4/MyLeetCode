public class leetcode11 {
    class Solution {
        public int maxArea(int[] height) {
            int min = 0;
            int max = height.length - 1;
            int res = 0;
            while (min <= max){
                res = Math.max(res, (max-min) * Math.min(height[min], height[max]));
                if(height[min] < height[max]){
                    min = min + 1;
                }else{
                    max = max - 1;
                }
            }
            return res;
        }
    }
}
