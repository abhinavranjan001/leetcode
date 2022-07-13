class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int sum = 0;
        for(int i=0; i<grumpy.length;i++){
            sum += grumpy[i]==1?0:customers[i];
        }
        int i = 0;
        int maxSum = 0, maxWinSum = Integer.MIN_VALUE;
        while(i<minutes && i < grumpy.length){
            maxSum += grumpy[i]==1?customers[i]:0;
            i++;
        }
        
        maxWinSum = maxSum;
        for(int j=0; i<customers.length;j++, i++){
            if(grumpy[j] == 1) maxSum -= customers[j];
            if(grumpy[i] == 1) maxSum += customers[i];
            maxWinSum = Math.max(maxWinSum, maxSum);
        }
        
        return sum + maxWinSum;
    }
}