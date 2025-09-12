/**
 * 40. Combination Sum II
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.
 * Note: The solution set must not contain duplicate combinations.
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
class Solution {
    // 1. The result List containing all unique combinations
    private List<List<Integer>> result = new ArrayList<>();

    /**
     * Main function to find all unique combinations that sum up to the target
     * @param candidates The array of candidate numbers
     * @param target The target sum
     * @return A list of all unique combinations that sum up to the target
     */
    public List<List<Integer>> combinationSum2(final int[] candidates, final int target) {
        // 1. Sort the candidates array to help with pruning and handling duplicates
        Arrays.sort(candidates);
        recursiveSumSearch(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void recursiveSumSearch(final int[] candidates, final int target, int startIndex, List<Integer> currentCombinations) {
        if (target == 0) {
            result.add(new ArrayList<>(currentCombinations));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue; // Skip duplicates
            }
            if (target - candidates[i] < 0) {
                break; // since it is sorted we can break here
            }

            currentCombinations.add(candidates[i]);
            recursiveSumSearch(candidates, target - candidates[i], i + 1, currentCombinations);
            currentCombinations.remove(currentCombinations.size() - 1);
        }
    }
}