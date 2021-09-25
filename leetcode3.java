public class leetcode3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int[] character = new int[128];
            int result = 0;
            int j = 0;
            int temp = 0;
            for(int i = 0; i < s.length(); i++){
                if(character[s.charAt(i)] == 0){
                    character[s.charAt(i)] = 1;
                    temp = temp + 1;
                    result = Math.max(result, temp);
                }else{
                    while(character[s.charAt(i)] == 1){
                        character[s.charAt(j)] = 0;
                        temp = temp - 1;
                        j++;
                    }
                    character[s.charAt(i)] = 1;
                    temp = temp + 1;
                }
            }
            return result;
        }
    }
}
