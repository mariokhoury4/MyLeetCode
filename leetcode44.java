import java.util.*;

public class leetcode44 {
    class Solution {
        public boolean isMatch(String s, String p) {
            int sLen = s.length();
            int pLen = p.length();
            
            // dp[i][j] represents whether p[0:i-1] could match s[0:j-1]
            boolean[][] dp = new boolean[pLen+1][sLen+1];
            dp[0][0]=true;
            
            for(int i=1;i<pLen+1;i++){
                // iterate over j according to p[i-1]
                if(p.charAt(i-1)=='*'){
                    int j = 1;
                    while((!dp[i-1][j-1]) && (j<sLen+1)){
                        j++;
                    }
                    dp[i][j-1] = dp[i-1][j-1];
                    while(j<sLen+1){
                        dp[i][j]=true;
                        j++;
                    }
                } else if (p.charAt(i-1)=='?'){
                    for(int j=1;j<sLen+1;j++){
                        dp[i][j] = dp[i-1][j-1];
                    }
                } else {
                    // not wildcard
                    for(int j=1;j<sLen+1;j++) {
                        dp[i][j] = dp[i-1][j-1] && p.charAt(i-1)==s.charAt(j-1);
                    }
                }
            }
            
            return dp[pLen][sLen];
        }
    }
}
