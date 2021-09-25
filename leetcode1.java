import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] result = new int[2];
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            temp = target - nums[i];
            if(map.containsKey(temp)){
                result[0] = map.get(temp);
                result[1] = i;
                return result;
            }else{
                map.put(nums[i], i);    
            }
            
        }
        return null;
    }
}