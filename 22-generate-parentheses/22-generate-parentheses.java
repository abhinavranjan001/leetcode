class Solution {
    List<String> result = new ArrayList();
    public List<String> generateParenthesis(int n) {
        
        recur(new StringBuilder(), n, n);
        return result;
        
    }
    
    public void recur(StringBuilder sb, int closing, int opening){
        if(opening == 0 && closing == 0){
            result.add(sb.toString());
        } else{
            if(opening > 0){
                sb.append("(");
                recur(sb, closing, opening-1);
                sb.setLength(sb.length()-1);
            }
        
            if(closing > 0 && closing > opening){
                sb.append(")");
                recur(sb, closing-1, opening);
                sb.setLength(sb.length()-1);
            }
            
            
        }
    }
}