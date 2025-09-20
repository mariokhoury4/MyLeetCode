class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;          // i -> s, j -> p
        int star = -1;             // last position of '*' in p
        int match = 0;             // position in s that '*' is currently matching

        while (i < s.length()) {
            // Direct match or '?'
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            }
            // Record '*' position and advance pattern
            else if (j < p.length() && p.charAt(j) == '*') {
                star = j++;
                match = i;         // '*' matches empty for now
            }
            // Mismatch: backtrack if we saw a '*'
            else if (star != -1) {
                j = star + 1;      // try to let '*' absorb one more char
                match++;
                i = match;
            }
            // No '*' to absorb mismatch
            else {
                return false;
            }
        }

        // Skip trailing '*' in pattern
        while (j < p.length() && p.charAt(j) == '*') j++;

        return j == p.length();
    }
}
