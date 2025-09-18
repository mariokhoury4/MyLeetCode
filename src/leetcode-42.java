/**
 * 42. Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Constraints:
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
class Solution {
    /**
     * Calculate the total water trapped in the structure
     * @param height the array of the heigth of each bar
     * @return the total water trapped in the strucutre
     */
    public int trap(final int[] height) {
        if (height == null || height.length < 3) {
            return 0; // need at least 3 bars
        }

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            // Update running maxima
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                // left side is the limiting wall
                water += leftMax - height[left]; // >= 0
                left++;
            } else {
                // right side is the limiting wall
                water += rightMax - height[right]; // >= 0
                right--;
            }
        }

        return water;
    }
}