/**
 * 39. Combination Sum
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 *
 *  Example 2:
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * Example 3:
 *
 * Input: candidates = [2], target = 1
 * Output: []
 *
 * Constraints:
 *
 * - 1 <= candidates.length <= 30
 * - 2 <= candidates[i] <= 40
 * - All elements of candidates are distinct.
 * - 1 <= target <= 40
 */
class Solution {

    // Using backtracking to find all unique combinations
    public Set<List<Integer>> result = new HashSet<>();

    /**
     * Main function to find all unique combinations that sum up to the target
     * @param candidates The array of distinct integers
     * @param target The target sum
     * @return A list of all unique combinations that sum up to the target
     */
    public List<List<Integer>> combinationSum(final int[] candidates, final int target) {
        // 1. Sort the candidates array to help with pruning
        Arrays.sort(candidates);

        // 2. Start backtracking from the first index with an empty combination
        backtrack(candidates, target, 0, 0, new ArrayList<>());

        // 3. Convert the result set to a list and return
        return new ArrayList<>(result);
    }

    /**
     * Backtracking helper function to explore all combinations
     * @param candidates The array of distinct integers
     * @param target The target sum
     * @param index The current index in candidates array
     * @param currentSum The current sum of the combination being explored
     * @param temp The current combination being explored
     */
    private void backtrack(final int[] candidates, final int target, int index, int currentSum, List<Integer> temp) {
        // 1. If current sum equals target, add the combination to the result set
        if (currentSum == target) {
            result.add(new ArrayList<>(temp));
        }

        // 2. Explore further combinations
        for (int i = index; i < candidates.length; i++) {

            // 2.1 Prune the search space if current sum exceeds target
            if (currentSum + candidates[i] > target) {
                break;
            }

            // 2.2 Include the candidate and explore further
            temp.add(candidates[i]);
            backtrack(candidates, target, i, currentSum + candidates[i], temp);
            temp.remove(temp.size() - 1);
        }
    }

}