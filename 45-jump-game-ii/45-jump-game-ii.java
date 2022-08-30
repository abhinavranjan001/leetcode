class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        for(int i = 0; i<nums.length; i++){
            int x = nums[i];
            while(x > 0){
                if(i+x > nums.length-1) x = nums.length-1-i;
                dp[i+x] = Math.min(dp[i+x], dp[i] + 1);
                x--;
            }
        }
        
        return dp[nums.length-1];
    }
}