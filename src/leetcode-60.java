/**
 * 60. Permutation Sequence
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 * Example 3:
 *
 * Input: n = 3, k = 1
 * Output: "123"
 *
 *
 * Constraints:
 *
 * 1 <= n <= 9
 * 1 <= k <= n!
 */
class Solution {
    public String getPermutation(int n, int k) {
        List<String> permutation = new ArrayList<>();
        getPermutationRec(permutation, n, new StringBuilder(), new boolean[n], k);
        return permutation.get(k - 1);
    }

    private void getPermutationRec(List<String> result, int n, StringBuilder temp, boolean[] visited, int k) {
        if (result.size() == k) {
            return;
        }
        if (temp.length() == n) {
            result.add(temp.toString());
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i - 1]) {
                continue;
            }
            temp.append(String.valueOf(i));
            visited[i - 1] = true;
            getPermutationRec(result, n, temp, visited, k);
            temp.deleteCharAt(temp.length() - 1);
            visited[i - 1] = false;
        }
    }
}