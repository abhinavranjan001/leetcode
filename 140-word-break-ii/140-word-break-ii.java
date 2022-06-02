class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList();
        dfs(result, s, 0, new ArrayList<String>(), new HashSet<String>(wordDict));
        return result;
    }
    
    public void dfs(List<String> result, String str, int start, ArrayList<String> curr, HashSet<String> hs){
        if(start >= str.length()) {
            StringBuilder sb = new StringBuilder();
            for(String s: curr){
                sb.append(s).append(" ");
            }
            sb.setLength(sb.length() - 1);
            result.add(sb.toString());
        }
        
        
        for(int e = start; e < str.length(); e++){
            if(hs.contains(str.substring(start, e+1))){
                curr.add(str.substring(start, e+1));
                dfs(result, str, e+1, curr, hs);
                curr.remove(curr.size()-1);
            }
        }
    }
}