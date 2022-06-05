class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        boolean[][] graph = new boolean[n][n];
        for(int[] dislike: dislikes){
            graph[dislike[0]-1][dislike[1]-1] = true;
            graph[dislike[1]-1][dislike[0]-1] = true;
        }
        
        int[] colors = new int[n];
        for(int i=0; i<n; i++){
            if(colors[i] == 0 && !canWeColor(graph, colors, 1, i))
                return false;
        }
        return true;
    }
    
    public boolean canWeColor(boolean[][] graph, int[] colors, int color, int thisNode){
        colors[thisNode] = color;
        for(int j=0; j<colors.length; j++){
            if(graph[thisNode][j] == true){
                if(colors[j] == -color) continue;
                else 
                    if(colors[j] == color || !canWeColor(graph, colors, -color, j)) return false;
            } 
        }
        return true;
    }
}