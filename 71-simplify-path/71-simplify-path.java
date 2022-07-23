class Solution {
    public String simplifyPath(String path) {
        String[] fNames = path.split("/");
            
        Stack<String> stack = new Stack();
        for(String str: fNames){
            if(!stack.isEmpty() && str.equals("..")){
                stack.pop();
            } else if(!str.equals("") && !str.equals(".") && !str.equals("..")){
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