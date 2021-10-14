import java.util.*;
public class leetcode49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new ArrayList<>();
            String[] temp = Arrays.copyOf(strs, strs.length);
            for(int i = 0; i < temp.length; i++){
                char tempArray[] = strs[i].toCharArray();
                Arrays.sort(tempArray);
                temp[i] = new String(tempArray);
            }
            Set<String> s = new HashSet<>();
            for(int i = 0; i < temp.length; i++){
                if(s.contains(temp[i])){
                    continue;
                }
                s.add(temp[i]);
                List<String> t = new ArrayList<>();
                t.add(strs[i]);
                for(int j = i + 1; j < temp.length; j++){
                    if(temp[i].equals(temp[j])){
                        t.add(strs[j]);
                    }
                }
                result.add(t);
            }
            return result;
        }
    }
}
