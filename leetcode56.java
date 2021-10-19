import java.util.*;
public class leetcode56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals.length <= 1) return intervals;
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            List<List<Integer>> temp = new ArrayList<>();
            int min = intervals[0][0];
            int max = intervals[0][1];
            for(int i = 1; i < intervals.length; i++){
                if(intervals[i][0] <= max){
                    max = Math.max(max, intervals[i][1]);
                }else{
                    List<Integer> t = new ArrayList<>();
                    t.add(min);
                    t.add(max);
                    min = intervals[i][0];
                    max = intervals[i][1];
                    temp.add(t);
                }
            }
            List<Integer> t = new ArrayList<>();
            t.add(min);
            t.add(max);
            min = intervals[intervals.length - 1][0];
            max = intervals[intervals.length - 1][1];
            temp.add(t);
            
            int[][] result = new int[temp.size()][2];
            for(int i = 0; i < temp.size(); i++){
                result[i][0] = temp.get(i).get(0);
                result[i][1] = temp.get(i).get(1);
            }        
            return result;
        }
    }
}
