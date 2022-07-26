class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        for(int v: nums){
            max = Math.max(max, v);
            sum += v;
        }
        
        int lo = max;
        int hi = sum;
        int ans = lo;
        
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            
            if(isPossible(nums, mid, m)){
                hi = mid-1;
                ans = mid;
            }else{
                lo = mid+1;
            }
        }
        
        return ans;
    }
    
    public boolean isPossible(int[] nums, int mid, int m){
        int sum=0, subArray=1;
        
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum > mid){
                sum = nums[i];
                subArray++;
                if(subArray > m) return false;
            }
        }
        
        if(subArray <= m) return true;
        else return false;
    }
}