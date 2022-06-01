class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        dfs(result, s, 0, new ArrayList(), new boolean[s.length()][s.length()]);
        return result;
    }

    public void dfs(List<List<String>> result, String str, int s, ArrayList<String> curr, boolean[][] dp) {
        if (s >= str.length()) result.add(new ArrayList(curr));
        else {
            // point to note is that we are not running the loop till end pointer but to the str.length()
            for (int i = s; i < str.length(); i++) {
                // why dp[s+1][e-1] ==> because the string starting from 's' and ending at 'e' will be a palindrome if charAt(s) == charAt(e) and
                // the substring starting at s+1 and ending at e-1 is also a substring
                if (str.charAt(s) == str.charAt(i) && ((i-s) <= 2 || dp[s + 1][i - 1])) {
                    dp[s][i] = true;
                    curr.add(str.substring(s, i + 1));
                    dfs(result, str, i + 1, curr, dp);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }


}