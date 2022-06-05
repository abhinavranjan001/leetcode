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
            // max length is 5 (to make it 1 indexed), this could be d+1, where d ==> maximum degree of 
            // any vertex in the graph
            // we are getting the colors of our neighbours, and then we will fill the color in our index whatever
            // is not taken by the neighbours
            boolean[] colors = new boolean[5];
            
            for(int nei: graph.get(i))
                // colors is holding all the colors taken by the neighbours
                colors[result[nei]] = true;
            
            for(int c=1; c<=4; c++)
                if(!colors[c]){
                    // pick the first color which is available
                    result[i] = c;
                    break;
                } 
        }
        
        return result;
    }
}