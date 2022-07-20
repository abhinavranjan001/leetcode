class Solution {
    public String convert(String s, int numRows) {
        
        StringBuilder[] sb = new StringBuilder[numRows];
            
        for(int i=0; i<numRows; i++)
            sb[i] = new StringBuilder();
        
        for(int i=0; i<s.length();){
            // going down
            for(int j=0; j<numRows && i < s.length(); j++)
                sb[j].append(s.charAt(i++));
            
            // going up
            for(int j=numRows-2; j>0 && i < s.length(); j--)
                sb[j].append(s.charAt(i++));
        }
        
        StringBuilder res = sb[0];
        for(int i=1; i<numRows; i++)
            res.append(sb[i]);
    
        return res.toString();
    }
}