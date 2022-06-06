class Solution {
    public int maxEnvelopes(int[][] E) {
        Arrays.sort(E, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        for (int i = 0; i < E.length; i++) {
            System.out.println(E[i][0] + " " + E[i][1]);
        }
        int[] dp = new int[E.length];
        int ans = 0;
        for (int[] env : E) {
            int height = env[1];
            int left = Arrays.binarySearch(dp, 0, ans, height);
            if (left < 0) left = -left - 1;
            if (left == ans) ans++;
            dp[left] = height;
        }
        return ans;
    }
}