class Solution {
    public String simplifyPath(String path) {
        String[] fNames = path.split("/");
            
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        Stack<String> stack = new Stack();
        for(String str: fNames){
            if(!stack.isEmpty() && str.equals("..")){
                stack.pop();
            } else if(!skip.contains(str)){
                stack.push(str);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(String str: stack){
            sb.append("/");
            sb.append(str);
        }
        return sb.length() == 0?"/":sb.toString();                                     
    }
}