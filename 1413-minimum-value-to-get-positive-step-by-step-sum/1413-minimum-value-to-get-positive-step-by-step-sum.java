class Solution {
    public int minStartValue(int[] nums) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        for(int i: nums){
            count += i;
            min = Math.min(min, count);
        }
        
        return min < 1? 1-min:1;
    }
}