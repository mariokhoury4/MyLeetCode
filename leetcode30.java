import java.util.*;
public class leetcode30 {
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            int len = words[0].length();
            Set<Integer> result = new HashSet<>();
            Map<String, Integer> set = new HashMap<>();
            for(int i = 0; i < words.length; i++){
                if(set.containsKey(words[i])){
                    set.put(words[i], set.get(words[i]) + 1);
                }else{
                    set.put(words[i], 1);
                }
            }
            int c = 0;
            int z = 0;
            Map<String, Integer> temp = new HashMap<>();
            for(int i = 0; i < s.length() - len + 1;){
                String t = "";
                for(int j = 0; j < len; j++){
                    t = t + s.charAt(i + j);
                }
                if(set.containsKey(t) == true && temp.containsKey(t) == false){
                    temp.put(t,1);
                    if(set.equals(temp)){
                        result.add(z);
                        temp = new HashMap<>();
                        i = z + 1;
                        z = i;
                    }else{
                        i = i + len;
                    }
                }else if(set.containsKey(t) == false){
                    temp = new HashMap<>();
                    i = c + 1;
                    c = c + 1;
                    z = i;
                }else if(set.containsKey(t) == true && temp.containsKey(t) == true){
                    if(set.get(t) > temp.get(t)){
                        temp.put(t, temp.get(t) + 1);
                        if(set.equals(temp)){
                            result.add(z);                   
                            temp = new HashMap<>();
                            i = z + 1;
                            z = i;
                        }else{
                            i = i + len;
                        }
                    }else if(set.get(t) == temp.get(t)){
                        String te = "";
                        for(int j = z; j < len + z; j++){
                            te = te + s.charAt(j);
                        }
                        z = z + len;
                        if(temp.get(te) > 1) {
                            temp.put(te, temp.get(te) - 1);
                        }
                        else {
                            temp.remove(te);
                        }
                    }
                }
            }
            List<Integer> res = new ArrayList<>(result);
            return res;
            
            
        }
    }
}