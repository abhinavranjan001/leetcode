class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, max_till_now = 0;
        for(int i= 0 ;i<nums.length; i++){
            max_till_now += nums[i];
            max = Math.max(max, max_till_now);
            if(max_till_now < 0) max_till_now=0;
        }
        
        return max;
    }
}