class Solution {
    class Pair implements Comparable<Pair> {
        int i, h;

        public Pair(int i, int h) {
            this.i = i;
            this.h = h;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.i == o.i) return this.h - o.h;
            else return this.i - o.i;
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> skyline = new ArrayList<>();
        
        Pair[] building = new Pair[buildings.length * 2];

        int i = 0;
        // divide into starting and ending points
        for (int[] a : buildings) {
            building[i++] = new Pair(a[0], -a[2]);
            building[i++] = new Pair(a[1], a[2]);
        }
        
        Arrays.sort(building);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        pq.add(0);
        int maxH = 0;
        for(Pair p: building){
            // if height is negative then means it is a starting point, include this height(rectangle)
            // else if height is positive then remove the rectangle since the it is ended.            
            if(p.h < 0) pq.add(-p.h);
            else pq.remove(p.h);
            
            // if height gets changed and if it is greater than maximum then update it
            if(maxH != pq.peek()) skyline.add(Arrays.asList(p.i, pq.peek()));
            maxH = pq.peek();
        }

        return skyline;
    }
}