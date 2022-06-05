class Solution {
    public boolean isBipartite(int[][] G) {        
        int[] colors = new int[G.length];
        for(int i=0; i<G.length; i++){
            if(colors[i] == 0 && !isAlreadyColored(G, colors, i, 1))
                return false;
        }
        
        return true;
    }
    
    public boolean isAlreadyColored(int [][]G, int[] colors, int start, int color){
        colors[start] = color;
        for(int i=0; i<G[start].length; i++){
            int nei = G[start][i];
            if(colors[nei] == -color) continue;
            if(colors[nei] == color || !isAlreadyColored(G, colors, nei, -color)) return false;
        }
        return true;
    }
    
}