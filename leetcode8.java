public class leetcode8 {
    class Solution {
        public int myAtoi(String s) {
            int size = s.length();
            if(size == 0) {
                return 0;
            }
            int i = 0;
            long result = 0;
            int sign = 1;
            boolean isnumberStarted = false;
            boolean isSignAssigned = false;
            while(i < size) {
                if(s.charAt(i) == ' ' && !isnumberStarted && !isSignAssigned) {
                    i++;
                    continue;
                }
                if((s.charAt(i) == '-' || s.charAt(i) == '+') && !isSignAssigned && !isnumberStarted) {
                    isSignAssigned = true;
                    if(s.charAt(i) == '-') {
                        sign = -1;
                    }
                    i++;
                    continue;
                }
                if(s.charAt(i) - '0' <= 9 && s.charAt(i) - '0' >= 0) {
                    isnumberStarted = true;
                    result = result*10 + (s.charAt(i) - '0');
                    if(result*sign < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                    if(result*sign > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    i++;
                } else {
                    break;
                }
            }
            return (int) (result*sign);
        }
    }
}
