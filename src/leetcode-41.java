/**
 * 41. First Missing Positive
 * Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 *
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 *
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: 1 is in the array but 2 is missing.
 *
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 */

class Solution {
    /**
     * Find the first missing positive integer in the array
     * @param nums The input array of integers
     * @return The smallest missing positive integer
     *
     */
    public int firstMissingPositive(int[] nums) {
        // 1. initialize the counter to iterate through the array
        final int arrayLength = nums.length;
        int index = 0;

        // 2. iterate through the array and inspect if each element is at it's position
        while (index < arrayLength) {
            final int temp = nums[index];
            if (temp >= 1 && temp <= arrayLength && nums[temp - 1] != temp) {
                swap(nums, index, temp - 1);
            } else {
                index = index + 1;
            }
        }

        //3 . iterate again into the array to find which element is not at the correct position and return it
        for (int i = 0; i < arrayLength; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 4. Else return the length of the array + 1 (next missing integer number)
        return arrayLength + 1;
    }

    /**
     * Swap the values of i and j in the array
     * @param nums the array of integers
     * @param i the first index
     * @param j the second index
     */
    private void swap(int[] nums, final int i, final int j) {
        final int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}