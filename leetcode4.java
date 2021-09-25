public class leetcode4 {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int i = 0;
            int j = 0;
            int c = 0;
            int mid = nums1.length + nums2.length;
            boolean odd = false;
            if (mid % 2 == 0){
                odd = true;
            }
            mid = mid / 2;
            double last = 0;
            double curr = 0;
            while (i<nums1.length && j<nums2.length){
                last = curr;
                if (nums1[i]<nums2[j]){
                    curr = nums1[i];
                    i = i + 1;
                }else{
                    curr = nums2[j];
                    j = j + 1;
                }
                c = c + 1;
                if (mid == c - 1){
                    if(odd == true){
                        return (curr + last)/2;
                    }else{
                        return curr;
                    }
                }
            }
            
            if (i<nums1.length){
                for(int z = i; z < nums1.length;z++){
                    last = curr;
                    curr = nums1[z];
                    c = c +1;
                    if (mid == c - 1){
                        if(odd == true){
                            return (curr + last)/2;
                        }else{
                            return curr;
                        }
                    }
                }
            } else if (j<nums2.length){
                for(int z = j; z < nums2.length;z++){
                    last = curr;
                    c = c + 1;
                    curr = nums2[z];
                    if (mid == c - 1){
                        if(odd == true){
                            return (curr + last)/2;
                        }else{
                            return curr;
                        }
                    }
                }
            }
            return 0;
        }
    }
}
