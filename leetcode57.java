import java.util.*;
public class leetcode57 {
    
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int[][] newIntervals = new int[intervals.length + 1][2];
        for(int i = 0; i < intervals.length; i++){
            newIntervals[i] = intervals[i];
        }
        newIntervals[newIntervals.length - 1] = newInterval;
        
        
        if(newIntervals.length <= 1) return newIntervals;
        Arrays.sort(newIntervals, (a, b) -> a[0] - b[0]);
        List<List<Integer>> temp = new ArrayList<>();
        int min = newIntervals[0][0];
        int max = newIntervals[0][1];
        for(int i = 1; i < newIntervals.length; i++){
            if(newIntervals[i][0] <= max){
                max = Math.max(max, newIntervals[i][1]);
            }else{
                List<Integer> t = new ArrayList<>();
                t.add(min);
                t.add(max);
                min = newIntervals[i][0];
                max = newIntervals[i][1];
                temp.add(t);
            }
        }
        List<Integer> t = new ArrayList<>();
        t.add(min);
        t.add(max);
        min = newIntervals[newIntervals.length - 1][0];
        max = newIntervals[newIntervals.length - 1][1];
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
