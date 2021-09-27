import java.util.*;
public class leetcode17 {


    class Solution {
        public List<String> rec (String temp, List<String> res, String digits, Map<Integer, String> map){
            if(temp.length() == digits.length()){
                res.add(temp);
                return res;
            }
            for(int i = 0; i < map.get(digits.charAt(temp.length()) - '0').length(); i++){
                temp = temp + map.get(digits.charAt(temp.length()) - '0').charAt(i);
                rec(temp, res, digits, map);
                temp = temp.substring(0, temp.length() - 1);
            }
            return res;
        }
        
        
        public List<String> letterCombinations(String digits) {
            if(digits.equals("")){
                List<String> re = new ArrayList<>();
                return re;
            }
            Map<Integer, String> map = new HashMap<>();
            map.put(2, "abc");
            map.put(3, "def");
            map.put(4, "ghi");
            map.put(5, "jkl");
            map.put(6, "mno");
            map.put(7, "pqrs");
            map.put(8, "tuv");
            map.put(9, "wxyz");
            return rec("", new ArrayList<>(), digits, map);
        }
    }
}
