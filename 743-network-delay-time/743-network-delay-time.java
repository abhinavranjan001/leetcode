class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList();
        
        for(int i = 0; i<n; i++)
            graph.add(new ArrayList<int[]>());
        
        for(int[] t : times)
            graph.get(t[0]-1).add(new int[]{t[1]-1, t[2]});
        
        int[] time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);
        
        recur(graph, k-1, 0, time);
        
        // minimum time will be the maximum time found in the array
        int min = Arrays.stream(time).max().getAsInt();
        return min == Integer.MAX_VALUE ? -1: min;
    }
    
    public void recur(List<List<int[]>> graph, int k, int cost, int[] time){
        // if we are unable to find the lower value for the node 'k' then return
        if(cost >= time[k]) return;
        time[k] = cost;

        for (int[] nei : graph.get(k)) 
                recur(graph, nei[0], cost + nei[1], time);
    }
}