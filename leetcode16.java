import java.util.*;

public class leetcode16 {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int closer = nums[0] + nums[1] + nums[2];
            Arrays.sort(nums);
            for(int i = 0; i < nums.length; i++){
                int min = 0;
                int max = nums.length - 1;
                while(min != max){
                    if(min == i){
                        min++;
                        continue;
                    }else if(max == i){
                        max--;
                        continue;
                    }
                    int temp = nums[min] + nums[max] + nums[i];
                    if(temp > target){
                        max = max - 1;
                    }else if (temp < target){
                        min = min + 1;
                    }else if (temp == target){
                        return target;
                    }
                    if(Math.abs(temp -target) < Math.abs(closer - target)){
                        closer = temp;
                    }
                }
            }
            return closer;
        }
    }
}
