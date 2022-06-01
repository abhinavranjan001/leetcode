class Solution {
    List<List<String>> result = new ArrayList();
    public List<List<String>> partition(String str) {
        recur(str, 0, new ArrayList<String>(), new boolean[str.length()+1][str.length()+1]);
        return result;
    }
    
    public void recur(String str, int s, List<String> temp, boolean[][] dp){
        if(s >= str.length()) result.add(new ArrayList<String>(temp));
        else{
            for(int i=s; i<str.length(); i++){
                if(str.charAt(s) == str.charAt(i) && ((i-s) <= 2 || dp[s+1][i-1])){
                    dp[s][i] = true;
                    temp.add(str.substring(s, i+1));
                    recur(str, i+1, temp, dp);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }

}