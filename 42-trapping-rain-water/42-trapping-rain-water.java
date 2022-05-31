class Solution {
    public int trap(int[] height) {
        int[] h = new int[height.length];
        h[0] = height[0];
        
        for(int i=1; i<height.length;i++){
            h[i] = Math.max(height[i], h[i-1]);
        }
        
        int ans = 0;
        int maxFromRight = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = height.length-1; i>=0; i--){
            maxFromRight = Math.max(height[i], maxFromRight);
            min = Math.min(maxFromRight, h[i]);
            ans += min-height[i];
        }
        
        return ans;
    }
}