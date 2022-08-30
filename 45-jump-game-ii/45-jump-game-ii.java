class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        
        dp[nums.length-1] = 0;
        for(int i=nums.length-2; i>=0; i--){
            dp[i] = 100000;
            for(int j=nums[i]; j>0; j--){
                 if(j == 0) 
                     dp[i] = 100000;
                 else if((i+j) < nums.length)
                   dp[i] = Math.min(1 + dp[i+j], dp[i]);
                else dp[i] = 1;
            }
        }
        
        return dp[0];
    }
}