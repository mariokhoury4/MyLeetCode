/**
 * 47. Permutations II
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        recursivePermutation(result, new ArrayList<>(), nums, new HashSet<>());
        return new ArrayList<>(result);
    }

    private void recursivePermutation(Set<List<Integer>> result, List<Integer> temp, int[] nums, Set<Integer> used) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used.contains(i)) {
                continue;
            }
            temp.add(nums[i]);
            used.add(i);
            recursivePermutation(result, temp, nums, used);
            temp.remove(temp.size() - 1);
            used.remove(i);
        }

    }
}