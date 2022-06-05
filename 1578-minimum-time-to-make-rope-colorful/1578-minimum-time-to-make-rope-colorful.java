class Solution {
    public int minCost(String colors, int[] nt) {
        int tot = 0, max = 0, res = 0;
        
        for(int i = 0; i<nt.length; i++){
            if(i > 0 && colors.charAt(i) != colors.charAt(i-1)){
                res += tot - max;
                tot = max = 0;
            }
            tot += nt[i];
            max = Math.max(max, nt[i]);
        }
        res += tot-max;
        return res;
    }
}