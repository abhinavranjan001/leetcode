class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet();
        for(String h: wordDict)
            dict.add(h);
        
        return recur(s, 0, dict, new Boolean[s.length()]);
    }
    public boolean recur(String s, int start, HashSet<String> dict, Boolean[] memo){
        if(start >= s.length()) return true;
        
        if(memo[start] != null) return memo[start];
        
        for(int e = start; e<s.length(); e++){
            if(dict.contains(s.substring(start, e+1)))
               if(recur(s, e+1, dict, memo)) return memo[start]=true;
        }
                   return memo[start]=false;
    }
}