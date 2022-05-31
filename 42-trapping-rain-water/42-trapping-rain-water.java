class Solution {
    public int trap(int[] height) {
        int[] rLargest = new int[height.length];
        
        int max = 0;
        int right = height.length-1;
        for(int i=height.length-1; i>=0; i--){
            if(max < height[i]){
                right = i;
                max = height[i];
            }
            rLargest[i] = right;
        }
        
        max = 0;
        int water = 0;
        int left = 0;
        int h = 0;
        for(int i=0; i<height.length-1; i++){
            if(max < height[i]){
                max = height[i];
                left = i;
            } 
            h = Math.min(height[left], height[rLargest[i]]);
            water += h-height[i];
        }
        
        return water;
    }
}