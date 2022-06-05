class Solution {
    LinkedList<String> result = new LinkedList<String>();
    int size = 0;
    public List<String> findItinerary(List<List<String>> tickets) {
        size = tickets.size();
        HashMap<String, PriorityQueue<String>> graph = new HashMap();
        
        for(List<String> ticket: tickets){
            if(!graph.containsKey(ticket.get(0))){
                graph.put(ticket.get(0), new PriorityQueue<String>());
            }
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        recur("JFK", graph);
        return result;
    }
    
    public void recur(String src, HashMap<String, PriorityQueue<String>> graph){
        PriorityQueue<String> pq = graph.get(src);
        if(pq != null)
        while(!pq.isEmpty()){
            recur(pq.poll(), graph);
        }
        result.addFirst(src);
    }
}