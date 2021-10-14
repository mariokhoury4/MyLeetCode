import java.util.*;
public class leetcode45 {
    class Solution {
        public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0 ; i < dp.length ; i++)
        {
            int jump = dp[i] + 1;
                
            for(int j = i+1 ; j <= i+nums[i] && j < dp.length ; j++)
            {
                dp[j] = Math.min(dp[j] , jump);
            }
        }
        return dp[dp.length-1];     
    }
    }
}
