/**
 * 15. 3Sum
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 *
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 *
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 * Constraints:
 * --> 3 <= nums.length <= 3000
 * --> -105 <= nums[i] <= 105
 */
class Solution {
    /**
     * Find all unique triplets in the array that sum to zero.
     *
     * @param nums the input array of integers
     * @return a list of lists containing the unique triplets
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 1. Initialize a List to store the result triplets
        List<List<Integer>> result = new ArrayList<>();

        // 2. Check if the input array is null or has fewer than 3 elements
        if  (nums == null || nums.length < 3) {
            return result;
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

                // 6.2 If the sum is zero, add the triplet to the result set
                if (sum == 0) {
                    // 6.3 Add the triplet to the result set
                    result.add(List.of(nums[index], nums[left], nums[right]));

                    // 6.4 Skip left duplicates
                    while (left < right && nums[left] == nums[left + 1]) {
                        left = left + 1;
                    }

                    // 6.5 Skip right duplicates
                    while (left < right && nums[right] == nums[right - 1]) {
                        right = right - 1;
                    }

                    // 6.6 Move both pointers inward to continue searching for other pairs
                    left = left + 1;
                    right = right - 1;
                } else if (sum < 0) {
                    // 6.7 If the sum is less than zero, move the left pointer to the right
                    left = left + 1;
                } else {
                    // 6.8 If the sum is greater than zero, move the right pointer to the left
                    right = right - 1;
                }
            }
        }

        // 7. Return the result as a list of lists
        return result;
    }
}