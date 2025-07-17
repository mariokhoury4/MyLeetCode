/**
 * 30. Substring with Concatenation of All Words
 * You are given a string s and an array of strings words. All the strings of words are of the same length.
 * A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
 * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
 * Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.
 *
 * Example 1:
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation:
 * The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
 * The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
 *
 * Example 2:
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * Explanation:
 * There is no concatenated substring.
 *
 * Example 3:
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 * Explanation:
 * The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
 * The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
 * The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].
 *
 * Constraints:
 *
 * --> 1 <= s.length <= 104
 * --> 1 <= words.length <= 5000
 * --> 1 <= words[i].length <= 30
 * --> s and words[i] consist of lowercase English letters.
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        Set<Integer> result = new HashSet<>();

        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!wordMap.containsKey(words[i])) {
                wordMap.put(words[i], 0);
            }
            wordMap.put(words[i], wordMap.get(words[i]) + 1);
        }



        int len = words[0].length();


        for (int i = 0; i < len; i++) {
            Map<String, Integer> subMap = new HashMap<>();
            int counter = 0;
            int left = i;
            int right = i;

            while (left < s.length() - len + 1 && right < s.length() - len + 1) {
                String leftSubString = s.substring(left, left + len);
                String rightSubString = s.substring(right, right + len);

                if (wordMap.containsKey(rightSubString)) {
                    if (subMap.containsKey(rightSubString)) {
                        if (wordMap.get(rightSubString) > subMap.get(rightSubString)) {
                            subMap.put(rightSubString, subMap.get(rightSubString) + 1);
                            counter = counter + 1;
                            right = right + len;
                            if (counter == words.length) {
                                result.add(left);
                                subMap.put(leftSubString, subMap.get(leftSubString) - 1);
                                left = left + len;
                                counter = counter - 1;
                            }
                        } else {
                            while (!leftSubString.equals(rightSubString)) {
                                subMap.put(leftSubString, subMap.get(leftSubString) - 1);
                                left = left + len;
                                counter = counter - 1;
                                leftSubString = s.substring(left, left + len);
                            }
                            left = left + len;
                            right = right + len;
                        }
                    } else {
                        subMap.put(rightSubString, 1);
                        counter = counter + 1;
                        right = right + len;
                        if (counter == words.length) {
                            result.add(left);
                            subMap.put(leftSubString, subMap.get(leftSubString) - 1);
                            left = left + len;
                            counter = counter - 1;
                        }
                    }

                } else {
                    counter = 0;
                    left = right + len;
                    right = left;
                    subMap = new HashMap<>();
                }
            }
        }


        return new ArrayList<>(result);
    }
}