/**
 * 34. Find First and Last Position of Element in Sorted Array
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 * Constraints:
 *
 * --> 0 <= nums.length <= 105
 * --> -109 <= nums[i] <= 109
 * --> nums is a non-decreasing array.
 * --> -109 <= target <= 109
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid;
                right = mid;
                while(left > 0 && nums[left] == target ) {
                    left--;
                }
                if (nums[left] == target) {
                    result[0] = left;
                } else {
                    result[0] = left + 1;
                }
                while(right < nums.length - 1 && nums[right] == target) {
                    right++;
                }
                if (nums[right] == target) {
                    result[1] = right;
                } else {
                    result[1] = right - 1;
                }
                return result;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        result[0] = -1;
        result[1] = -1;
        return result;
    }
}