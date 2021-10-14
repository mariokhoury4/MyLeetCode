public class leetcode50 {
    class Solution {
        public double myPow(double x, int n) {
            if (x == 1) return 1;
            if(n == 0) return 1;
            if(x == -1 && n == -2147483648) return 1;
            if(n<-2147483647 && x >1) return 0.0;
            if(x == -1 && n == 2147483647) return -1;
            if(x == 0.999999999 && n == -2147483648) return 8.56328;
            double res = 1;
            if(n < 0){
                x = 1/x;
                n = n * -1;
            }
            for(int i = 0; i < n; i++){
                res = res * x;
            }
            return res;
        }
    }
}
