/**
 * 4. Median of Two Sorted Arrays
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * Constraints:
 *
 * - nums1.length == m
 * - nums2.length == n
 * - 0 <= m <= 1000
 * - 0 <= n <= 1000
 * - 1 <= m + n <= 2000
 * - -106 <= nums1[i], nums2[i] <= 106
 */
class Solution {
    /**
     * Find the median of two sorted arrays.
     * @param nums1
     * @param nums2
     * @return the median of the two sorted arrays
     */
    public double findMedianSortedArrays(final int[] firstSortedArray, final int[] secondSortedArray) {
        // 1. Initialize the lengths of the input arrays.
        final int lengthFirstSortedArray = firstSortedArray.length;
        final int lengthSecondSortedArray = secondSortedArray.length;

        // 2. Handle edge cases where both arrays are empty or one of them is empty and second one has only 1 element.
        if (lengthFirstSortedArray + lengthSecondSortedArray == 0) {
            return 0;
        } else if (lengthFirstSortedArray == 1 && lengthSecondSortedArray == 0) {
            return firstSortedArray[0];
        } else if (lengthFirstSortedArray == 0 && lengthSecondSortedArray == 1) {
            return secondSortedArray[0];
        }

        // 3. Get the half way of the arrays and if it is odd or even
        final int midPoint = (lengthFirstSortedArray + lengthSecondSortedArray) / 2;
        final boolean isEven = (lengthFirstSortedArray + lengthSecondSortedArray) % 2 == 0;

        // 4. Initialize the counters and indexes
        int currentFirstIndex = 0;
        int currentSecondIndex = 0;
        double currentNumber = 0;

        // 5. Iterate through the arrays until we reach the midPoint
        while (currentFirstIndex + currentSecondIndex < midPoint) {
            if (currentSecondIndex >= lengthSecondSortedArray || (currentFirstIndex < lengthFirstSortedArray && firstSortedArray[currentFirstIndex] < secondSortedArray[currentSecondIndex])) {
                currentNumber = firstSortedArray[currentFirstIndex];
                currentFirstIndex = currentFirstIndex + 1;
            } else {
                currentNumber = secondSortedArray[currentSecondIndex];
                currentSecondIndex = currentSecondIndex + 1;
            }
        }
        // 6. If the total length is even, we need to find the next number as well
        if (isEven) {
            if (currentFirstIndex >= lengthFirstSortedArray) {
                return (currentNumber + secondSortedArray[currentSecondIndex]) / 2;
            } else if (currentSecondIndex >= lengthSecondSortedArray) {
                return (currentNumber + firstSortedArray[currentFirstIndex]) / 2;
            }
            return (currentNumber + Math.min(firstSortedArray[currentFirstIndex], secondSortedArray[currentSecondIndex])) / 2;
        }
        // 7. If the total length is odd, we just return the current number
        if (currentFirstIndex >= lengthFirstSortedArray) {
            return secondSortedArray[currentSecondIndex];
        } else if (currentSecondIndex >= lengthSecondSortedArray) {
            return firstSortedArray[currentFirstIndex];
        }
        return Math.min(firstSortedArray[currentFirstIndex], secondSortedArray[currentSecondIndex]);


    }
}