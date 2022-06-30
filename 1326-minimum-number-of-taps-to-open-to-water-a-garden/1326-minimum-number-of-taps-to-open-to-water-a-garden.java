class Solution {
    public int minTaps(int n, int[] ranges) {
        int[][] range = new int[ranges.length][2];
        for(int i=0;i<ranges.length;i++){
            range[i][0] = (i-ranges[i]) > 0? (i-ranges[i]): 0;
            range[i][1] = i+ranges[i];
        }
        
        int res = 0;
        Arrays.sort(range, (a,b) ->  a[0] - b[0]);
        for (int i = 0, st = 0, end = 0; st < n; st = end, ++res) {
            for (; i < range.length && range[i][0] <= st; ++i)
                end = Math.max(end, range[i][1]);
            if (st == end) return -1;
        }
        return res;
    }
}