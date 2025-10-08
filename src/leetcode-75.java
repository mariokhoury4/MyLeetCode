/**
 * 75. Sort Colors
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 *
 *
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
class Solution {
    public void sortColors(int[] nums) {
        int firstColorIndex = 0;
        int lastColorIndex = nums.length - 1;

        int index = 0;
        while (index <= lastColorIndex) {
            if (nums[index] == 0) {
                nums[index] = nums[firstColorIndex];
                nums[firstColorIndex] = 0;
                index = index + 1;
                firstColorIndex = firstColorIndex + 1;
            } else if (nums[index] == 2) {
                nums[index] = nums[lastColorIndex];
                nums[lastColorIndex] = 2;
                lastColorIndex = lastColorIndex - 1;
            } else {
                index = index + 1;
            }
        }
    }
}