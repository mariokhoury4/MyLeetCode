/**
 * 18. 4Sum
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * Example 2:
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 *
 * Constraints:
 * --> 1 <= nums.length <= 200
 * --> -109 <= nums[i] <= 109
 * --> -109 <= target <= 109
 */
class Solution {
    /**
     * Find all unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
     * @param nums The input array of integers
     * @param target The target sum for the quadruplets
     * @return A list of lists containing all unique quadruplets that sum to the target
     */
    public List<List<Integer>> fourSum(int[] nums, final int target) {
        // 1. Initialize the list of results
        List<List<Integer>> result = new ArrayList<>();

        // 2. Sort the input array to use two pointers
        Arrays.sort(nums);

        // 3. Iterate through the array with two nested loops
        for (int i = 0; i < nums.length - 3; i++) {
            // 3.1 skip duplicate for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 3.2 Iterate through the array with a second loop
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 3.3 skip duplicate for j
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 3.4 Use two pointers to find pairs that sum to the target
                int left = j + 1;
                int right = nums.length - 1;

                // 4. While the left pointer is less than the right pointer
                while (left < right) {
                    // 4.1 Calculate the sum of the four numbers
                    final long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    // 4.2 Check if the sum equals the target
                    if (sum == target) {
                        // 4.3 Add the quadruplet to the result
                        result.add(List.of(nums[i], nums[j], nums[left], nums[right]));

                        // 4.4 skip duplicate left
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        // 4.5 skip duplicate right
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        // 4.6 Move both pointers inward
                        left = left + 1;
                        right = right - 1;
                    } else if (sum < target) {
                        left = left + 1;
                    } else {
                        right = right - 1;
                    }
                }
            }
        }

        // 5. Return the list of unique quadruplets
        return result;
    }
}