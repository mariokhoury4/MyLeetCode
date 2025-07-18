/**
 * 33. Search in Rotated Sorted Array
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 *
 * Constraints:
 *
 * --> 1 <= nums.length <= 5000
 * --> -104 <= nums[i] <= 104
 * --> All values of nums are unique.
 * --> nums is an ascending array that is possibly rotated.
 * --> -104 <= target <= 104
 */
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int cutIndex = 0;

        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            firstList.add(nums[i]);
            if (nums[i] > nums[i + 1]) {
                cutIndex = i + 1;
                break;
            }
        }

        for (int i = cutIndex; i < nums.length; i++) {
            secondList.add(nums[i]);
        }

        List<Integer> neededList = new ArrayList<>();

        boolean checkFirstList = false;
        if (nums[nums.length - 1] < target) {
            neededList = firstList;
            checkFirstList = true;
        } else {
            neededList = secondList;
        }

        int left = 0;
        int right = neededList.size() - 1;
        int resultIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (neededList.get(mid) == target) {
                resultIndex = mid;
                break;
            } else if (neededList.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (resultIndex == -1) {
            return -1;
        }
        if (checkFirstList) {
            return resultIndex;
        } else {
            return resultIndex + cutIndex;
        }

    }
}