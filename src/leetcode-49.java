/**
 * 49. Group Anagrams
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Explanation:
 *
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 * Example 2:
 *
 * Input: strs = [""]
 *
 * Output: [[""]]
 *
 * Example 3:
 *
 * Input: strs = ["a"]
 *
 * Output: [["a"]]
 *
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists o
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> visited = new HashMap<>();
        for (String str : strs) {
            int[] array = new int[26];
            for (int i = 0, len = str.length(); i < len; i++) {
                array[str.charAt(i) - 'a']++;
            }

            // Build compact key like "#1#0#0...#2"
            StringBuilder sb = new StringBuilder(26 * 2);
            for (int c : array) {
                sb.append('#').append(c);
            }
            String key = sb.toString();

            if (visited.containsKey(key)) {
                visited.get(key).add(str);
            } else {
                visited.put(key, new ArrayList<>(Arrays.asList(str)));
            }
        }

        for (List<String> anagrams : visited.values()) {
            result.add(anagrams);
        }
        return result;

    }
}