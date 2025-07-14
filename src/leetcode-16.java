/**
 * 16. 3Sum Closest
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * Example 1:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Example 2:
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 *
 * Constraints:
 * --> 3 <= nums.length <= 500
 * --> -1000 <= nums[i] <= 1000
 * --> -104 <= target <= 104
 */
class Solution {
    /**
     * Find the sum of three integers in the array that is closest to the target.
     * @param nums the input array of integers
     * @param target the target integer
     * @return the sum of the three integers closest to the target
     */
    public int threeSumClosest(int[] nums, final int target) {
        // 1. Initialize a variable to store the closest sum
        int result = Integer.MAX_VALUE;

        // 2. Check if the input array is null or has fewer than 3 elements
        if  (nums == null || nums.length < 3) {
            return 0;
        }

        // 3. Sort the input array to facilitate the two-pointer technique
        Arrays.sort(nums);

        // 4. Iterate through the array to find triplets
        for (int index = 0; index < nums.length - 2; index++) {
            // 4.1. Skip duplicate elements to avoid duplicate triplets
            if (index > 0 && nums[index] == nums[index - 1]) {
                continue;
            }

            // 5. Use two pointers to find pairs that sum to the negative of the current element.
            int left = index + 1;
            int right = nums.length - 1;

            // 6. While the left pointer is less than the right pointer
            while (right > left) {
                // 6.1 Calculate the sum of the current element and the two pointers
                final int sum = nums[index] + nums[left] + nums[right];

                // 6.2 Check if the absolute difference between the sum and target is less than the absolute
                //     difference between the current result and target
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }

                // 6.3 If the sum is equal to the target, return the target immediately
                if (sum == target) {
                    return target;
                } else if (sum - target > 0) {
                    // 6.4 If the sum is greater than the target, move the right pointer left
                    right = right - 1;
                } else {
                    // 6.5 If the sum is less than the target, move the left pointer right
                    left = left + 1;
                }
            }
        }
        // 7. Return the result as a list of lists
        return result;
    }
}