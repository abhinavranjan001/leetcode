class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
                if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++)
                centroids.add(i);
            return centroids;
        }
        ArrayList<HashSet<Integer>> adj = new ArrayList<HashSet<Integer>>();
        for(int i=0; i<n;i++){
            adj.add(new HashSet<Integer>());
        }
        
        for(int i = 0; i< edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        ArrayList<Integer> leaves = new ArrayList<Integer>();
        for(int i = 0;i<n;i++)
            if(adj.get(i).size() == 1) leaves.add(i);
        
        int remaingNodes = n;
        while(remaingNodes > 2){
            remaingNodes = remaingNodes - leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<Integer>();
            
            for (Integer leaf : leaves) {
                // the only neighbor left for the leaf node
                Integer neighbor = adj.get(leaf).iterator().next();
                // remove the edge along with the leaf node
                adj.get(neighbor).remove(leaf);
                if (adj.get(neighbor).size() == 1)
                    newLeaves.add(neighbor);
            }

            // prepare for the next round
            leaves = newLeaves;
        }

        // The remaining nodes are the centroids of the graph
        return leaves;
            
        }
}