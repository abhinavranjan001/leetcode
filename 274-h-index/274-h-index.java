class Solution {
    public int hIndex(int[] citations) {
        int[] memo = new int[1001];
        
        for(int i: citations)
            memo[i]++;
        
        int sum=0;
        for(int i=1000; i>=0; i--){
            sum += memo[i];
            if(sum >=i) return i;
        }
        
        return 0;
    }
}