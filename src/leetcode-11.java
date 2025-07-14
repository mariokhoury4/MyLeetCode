/**
 * 11. Container With Most Water
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 *
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 *
 * Constraints:
 * --> n == height.length
 * --> 2 <= n <= 105
 * --> 0 <= height[i] <= 104
 */
class Solution {
    /**
     * Find the maximum area of water that can be contained between two lines.
     * @param height the heights of the vertical lines
     * @return the maximum area of water that can be contained
     */
    public int maxArea(final int[] height) {
        // 1. Initialize the result variable
        int maxAreaValue = 0;

        // 2. Use two pointers to traverse the array from both ends
        int left = 0;
        int right = height.length - 1;

        // 3. While the left pointer is less than the right pointer
        while (left < right) {
            // 4. Calculate the area formed by the lines at the left and right pointers
            maxAreaValue = Math.max(maxAreaValue, Math.min(height[left], height[right]) * (right - left));

            // 5. Move the pointer pointing to the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        // 6. Return the maximum area found
        return maxAreaValue;
    }
}