/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
class Solution {

    /**
     * Default value to return when no solution is found.
     */
    private static final int[] DEFAULT_VALUE = new int[] {-1, -1};

    /**
     * Find two indices in the array such that the numbers at those indices add up to the target.
     *
     * @param nums an array of integers
     * @param target an integer target
     * @return indices of the two numbers such that they add up to target
     */
    public int[] twoSum(final int[] nums, final int target) {
        // 1. Initialise a map to store numbers and their indices.
        final Map<Integer, Integer> numbersToIndexMap = new HashMap<>();

        // 2. Iterate through the array.
        for (int index = 0; index < nums.length; index++) {

            // 3. Check if the complement (target - current number) exists in the map.
            if (numbersToIndexMap.containsKey(target - nums[index])) {
                // 4. If found, return the indices of the current number and its complement.
                return new int[] {numbersToIndexMap.get(target - nums[index]), index};
            }
            // 5. If not found, add the current number and its index to the map.
            numbersToIndexMap.put(nums[index], index);
        }

        // 6. If no solution is found, return the default value.
        return DEFAULT_VALUE;
    }
}