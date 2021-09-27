public class leetcode14 {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String res = "";
            int i = 0;
            while(i != strs[0].length()){
                String temp = strs[0];
                for(int j = 1; j < strs.length; j++){
                    if(strs[j].length() == i ||strs[j].charAt(i) != temp.charAt(i)){
                        return res;
                    }
                }
                res = res + temp.charAt(i);
                i = i + 1;
            }
            return res;
            
        }
    }
}
