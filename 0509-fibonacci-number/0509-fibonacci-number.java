class Solution {
    public int fib(int n) {
        if (n==0){
            return 0;
        }
        int val1 = 0;
        int val2 = 1;
        int total = 1;        
        for (int i = 1 ; i < n ; i++){
            total = val1 + val2;
            val1 = val2;
            val2 = total;
        }
        
        return total;
    }
}