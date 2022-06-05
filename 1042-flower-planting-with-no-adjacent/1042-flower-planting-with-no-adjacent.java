class Solution {
    public int[] gardenNoAdj(int n, int[][] edges) {
    
        List<List<Integer>> graph = new ArrayList();
        
        for(int i=0; i<n; i++){
            graph.add(new ArrayList());
        }
        
        for(int[] edge: edges){
            graph.get(edge[0]-1).add(edge[1]-1);
            graph.get(edge[1]-1).add(edge[0]-1);
        }
        
        int[] result = new int[n];
        
        for(int i=0; i<n; i++){
            boolean[] colors = new boolean[5];
            
            for(int nei: graph.get(i))
                colors[result[nei]] = true;
            
            for(int c=1; c<=4; c++)
                if(!colors[c]){
                    result[i] = c;
                    break;
                } 
        }
        
        return result;
    }
}